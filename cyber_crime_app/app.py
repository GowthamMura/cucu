import os
import sqlite3
from datetime import datetime

import numpy as np
import pandas as pd
from flask import Flask, flash, redirect, render_template, request, session, url_for
from werkzeug.utils import secure_filename

BASE_DIR = os.path.dirname(os.path.abspath(__file__))
DB_PATH = os.path.join(BASE_DIR, "cyber_crime.db")
UPLOAD_FOLDER = os.path.join(BASE_DIR, "uploads")
ALLOWED_EXTENSIONS = {"csv"}

app = Flask(__name__)
app.secret_key = "change-this-secret-in-production"
app.config["UPLOAD_FOLDER"] = UPLOAD_FOLDER


# ---------- Database helpers ----------
def get_connection():
    conn = sqlite3.connect(DB_PATH)
    conn.row_factory = sqlite3.Row
    return conn


def init_db():
    conn = get_connection()
    cur = conn.cursor()

    cur.execute(
        """
        CREATE TABLE IF NOT EXISTS users (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            username TEXT UNIQUE NOT NULL,
            password TEXT NOT NULL
        )
        """
    )

    cur.execute(
        """
        CREATE TABLE IF NOT EXISTS crime_reports (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            crime_type TEXT NOT NULL,
            description TEXT NOT NULL,
            location TEXT NOT NULL,
            report_date TEXT NOT NULL,
            severity_level TEXT NOT NULL,
            created_at TEXT NOT NULL
        )
        """
    )

    cur.execute(
        """
        CREATE TABLE IF NOT EXISTS app_meta (
            key TEXT PRIMARY KEY,
            value TEXT NOT NULL
        )
        """
    )

    cur.execute(
        "INSERT OR IGNORE INTO users (username, password) VALUES (?, ?)",
        ("admin", "admin123"),
    )

    conn.commit()
    conn.close()


def set_meta(key, value):
    conn = get_connection()
    conn.execute(
        "INSERT INTO app_meta(key, value) VALUES (?, ?) ON CONFLICT(key) DO UPDATE SET value=excluded.value",
        (key, value),
    )
    conn.commit()
    conn.close()


def get_meta(key):
    conn = get_connection()
    row = conn.execute("SELECT value FROM app_meta WHERE key = ?", (key,)).fetchone()
    conn.close()
    return row["value"] if row else None


# ---------- Utilities ----------
def login_required():
    return "user_id" in session


def allowed_file(filename):
    return "." in filename and filename.rsplit(".", 1)[1].lower() in ALLOWED_EXTENSIONS


def load_dataset_df():
    conn = get_connection()
    try:
        df = pd.read_sql_query("SELECT * FROM dataset_records", conn)
    except Exception:
        df = pd.DataFrame()
    finally:
        conn.close()

    if not df.empty:
        if "Year" in df.columns:
            df["Year"] = pd.to_numeric(df["Year"], errors="coerce").astype("Int64")
        if "Victim_Age" in df.columns:
            df["Victim_Age"] = pd.to_numeric(df["Victim_Age"], errors="coerce")
    return df


def dashboard_metrics(df):
    if df.empty:
        return {
            "total_crimes": 0,
            "most_common": "N/A",
            "latest_year": "N/A",
            "trend_direction": "No data",
        }

    total_crimes = len(df)
    most_common = (
        df["Crime_Type"].mode().iloc[0]
        if "Crime_Type" in df.columns and not df["Crime_Type"].dropna().empty
        else "N/A"
    )
    latest_year = (
        int(df["Year"].dropna().max()) if "Year" in df.columns and not df["Year"].dropna().empty else "N/A"
    )

    trend_direction = "No data"
    if "Year" in df.columns:
        trend = df.groupby("Year").size().sort_index()
        if len(trend) >= 2:
            trend_direction = "Increasing" if trend.iloc[-1] >= trend.iloc[0] else "Decreasing"

    return {
        "total_crimes": int(total_crimes),
        "most_common": most_common,
        "latest_year": latest_year,
        "trend_direction": trend_direction,
    }


def chart_payloads(df):
    if df.empty:
        return {
            "crime_type_labels": [],
            "crime_type_values": [],
            "year_labels": [],
            "year_values": [],
            "location_labels": [],
            "location_values": [],
            "severity_labels": [],
            "severity_values": [],
        }

    crime_type = df["Crime_Type"].value_counts().head(10)
    by_year = df.groupby("Year").size().sort_index()
    by_location = df["Location"].value_counts().head(10)
    by_severity = df["Severity_Level"].value_counts()

    return {
        "crime_type_labels": crime_type.index.tolist(),
        "crime_type_values": crime_type.values.tolist(),
        "year_labels": [str(x) for x in by_year.index.tolist()],
        "year_values": by_year.values.tolist(),
        "location_labels": by_location.index.tolist(),
        "location_values": by_location.values.tolist(),
        "severity_labels": by_severity.index.tolist(),
        "severity_values": by_severity.values.tolist(),
    }


def normalize_dataset(df):
    expected = [
        "Case_ID",
        "Crime_Type",
        "Location",
        "State",
        "Year",
        "Victim_Age",
        "Severity_Level",
        "Description",
    ]

    missing = [col for col in expected if col not in df.columns]
    if missing:
        raise ValueError(f"Missing required columns: {', '.join(missing)}")

    df = df[expected].copy()
    df["Year"] = pd.to_numeric(df["Year"], errors="coerce").fillna(0).astype(int)
    df["Victim_Age"] = pd.to_numeric(df["Victim_Age"], errors="coerce").fillna(0).astype(int)

    for col in ["Case_ID", "Crime_Type", "Location", "State", "Severity_Level", "Description"]:
        df[col] = df[col].astype(str).replace("nan", "")

    return df


os.makedirs(UPLOAD_FOLDER, exist_ok=True)
init_db()


# ---------- Routes ----------
@app.route("/")
def home():
    if login_required():
        return redirect(url_for("dashboard"))
    return redirect(url_for("login"))


@app.route("/login", methods=["GET", "POST"])
def login():
    if request.method == "POST":
        username = request.form.get("username", "").strip()
        password = request.form.get("password", "").strip()

        conn = get_connection()
        user = conn.execute(
            "SELECT * FROM users WHERE username = ? AND password = ?", (username, password)
        ).fetchone()
        conn.close()

        if user:
            session["user_id"] = user["id"]
            session["username"] = user["username"]
            flash("Login successful.", "success")
            return redirect(url_for("dashboard"))

        flash("Invalid credentials. Try admin / admin123.", "danger")

    return render_template("login.html")


@app.route("/logout")
def logout():
    session.clear()
    flash("Logged out successfully.", "info")
    return redirect(url_for("login"))


@app.route("/dashboard")
def dashboard():
    if not login_required():
        return redirect(url_for("login"))

    df = load_dataset_df()
    metrics = dashboard_metrics(df)
    charts = chart_payloads(df)
    last_upload = get_meta("last_upload")

    return render_template(
        "dashboard.html", metrics=metrics, charts=charts, last_upload=last_upload
    )


@app.route("/upload-dataset", methods=["GET", "POST"])
def upload_dataset():
    if not login_required():
        return redirect(url_for("login"))

    preview_rows = []
    preview_columns = []

    if request.method == "POST":
        file = request.files.get("dataset")
        if not file or file.filename == "":
            flash("Please choose a CSV file.", "warning")
            return redirect(url_for("upload_dataset"))

        if not allowed_file(file.filename):
            flash("Only CSV files are allowed.", "danger")
            return redirect(url_for("upload_dataset"))

        filename = secure_filename(file.filename)
        filepath = os.path.join(app.config["UPLOAD_FOLDER"], filename)
        file.save(filepath)

        try:
            df = pd.read_csv(filepath)
            df = normalize_dataset(df)
            conn = get_connection()
            df.to_sql("dataset_records", conn, if_exists="replace", index=False)
            conn.commit()
            conn.close()
            set_meta("last_upload", datetime.now().strftime("%Y-%m-%d %H:%M:%S"))
            flash("Dataset uploaded and processed successfully.", "success")
            preview_columns = df.columns.tolist()
            preview_rows = df.head(10).replace(np.nan, "").to_dict(orient="records")
        except Exception as exc:
            flash(f"Failed to process dataset: {exc}", "danger")

    return render_template(
        "upload_dataset.html",
        preview_rows=preview_rows,
        preview_columns=preview_columns,
    )


@app.route("/crime-search", methods=["GET", "POST"])
def crime_search():
    if not login_required():
        return redirect(url_for("login"))

    results = []
    df = load_dataset_df()

    if request.method == "POST" and not df.empty:
        crime_type = request.form.get("crime_type", "").strip().lower()
        location = request.form.get("location", "").strip().lower()
        year = request.form.get("year", "").strip()
        case_id = request.form.get("case_id", "").strip().lower()

        filtered = df.copy()
        if crime_type:
            filtered = filtered[filtered["Crime_Type"].str.lower().str.contains(crime_type, na=False)]
        if location:
            filtered = filtered[filtered["Location"].str.lower().str.contains(location, na=False)]
        if year:
            filtered = filtered[filtered["Year"].astype(str) == year]
        if case_id:
            filtered = filtered[filtered["Case_ID"].str.lower().str.contains(case_id, na=False)]

        results = filtered.head(200).to_dict(orient="records")

    return render_template("crime_search.html", results=results)


@app.route("/crime-report", methods=["GET", "POST"])
def crime_report():
    if not login_required():
        return redirect(url_for("login"))

    if request.method == "POST":
        crime_type = request.form.get("crime_type", "").strip()
        description = request.form.get("description", "").strip()
        location = request.form.get("location", "").strip()
        report_date = request.form.get("report_date", "").strip()
        severity_level = request.form.get("severity_level", "").strip()

        if not all([crime_type, description, location, report_date, severity_level]):
            flash("All fields are required.", "warning")
            return redirect(url_for("crime_report"))

        conn = get_connection()
        conn.execute(
            """
            INSERT INTO crime_reports (crime_type, description, location, report_date, severity_level, created_at)
            VALUES (?, ?, ?, ?, ?, ?)
            """,
            (crime_type, description, location, report_date, severity_level, datetime.now().isoformat()),
        )
        conn.commit()
        conn.close()
        flash("Crime report submitted successfully.", "success")
        return redirect(url_for("crime_report"))

    conn = get_connection()
    recent_reports = conn.execute(
        "SELECT * FROM crime_reports ORDER BY id DESC LIMIT 10"
    ).fetchall()
    conn.close()

    return render_template("crime_report.html", recent_reports=recent_reports)


@app.route("/data-filter", methods=["GET", "POST"])
def data_filter():
    if not login_required():
        return redirect(url_for("login"))

    df = load_dataset_df()
    results = []

    if request.method == "POST" and not df.empty:
        year = request.form.get("year", "").strip()
        category = request.form.get("category", "").strip().lower()
        state_city = request.form.get("state_city", "").strip().lower()
        severity = request.form.get("severity", "").strip().lower()

        filtered = df.copy()
        if year:
            filtered = filtered[filtered["Year"].astype(str) == year]
        if category:
            filtered = filtered[filtered["Crime_Type"].str.lower().str.contains(category, na=False)]
        if state_city:
            filtered = filtered[
                filtered["State"].str.lower().str.contains(state_city, na=False)
                | filtered["Location"].str.lower().str.contains(state_city, na=False)
            ]
        if severity:
            filtered = filtered[filtered["Severity_Level"].str.lower().str.contains(severity, na=False)]

        results = filtered.head(200).to_dict(orient="records")

    return render_template("data_filter.html", results=results)


if __name__ == "__main__":
    os.makedirs(UPLOAD_FOLDER, exist_ok=True)
    init_db()
    app.run(debug=True)
