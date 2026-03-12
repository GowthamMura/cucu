from flask import Blueprint, flash, redirect, render_template, request, url_for

from healthcare_billing.extensions import db
from healthcare_billing.models import (
    Doctor,
    Employee,
    Equipment,
    Infrastructure,
    OtherExpense,
    Patient,
)

forms_bp = Blueprint("forms", __name__)


@forms_bp.route("/")
def index():
    return render_template("index.html")


@forms_bp.route("/doctors", methods=["GET", "POST"])
def doctor_form():
    if request.method == "POST":
        doctor = Doctor(
            name=request.form["name"],
            specialization=request.form["specialization"],
            consultation_fee=float(request.form["consultation_fee"]),
        )
        db.session.add(doctor)
        db.session.commit()
        flash("Doctor record saved successfully.", "success")
        return redirect(url_for("forms.doctor_form"))
    return render_template("doctor_form.html")


@forms_bp.route("/patients", methods=["GET", "POST"])
def patient_form():
    doctors = Doctor.query.order_by(Doctor.name).all()

    if request.method == "POST":
        patient = Patient(
            name=request.form["name"],
            age=int(request.form["age"]),
            gender=request.form["gender"],
            diagnosis=request.form.get("diagnosis"),
            billed_amount=float(request.form["billed_amount"]),
            doctor_id=int(request.form["doctor_id"]),
        )
        db.session.add(patient)
        db.session.commit()
        flash("Patient record saved successfully.", "success")
        return redirect(url_for("forms.patient_form"))

    return render_template("patient_form.html", doctors=doctors)


@forms_bp.route("/employees", methods=["GET", "POST"])
def employee_form():
    if request.method == "POST":
        employee = Employee(
            name=request.form["name"],
            role=request.form["role"],
            salary=float(request.form["salary"]),
        )
        db.session.add(employee)
        db.session.commit()
        flash("Employee record saved successfully.", "success")
        return redirect(url_for("forms.employee_form"))
    return render_template("employee_form.html")


@forms_bp.route("/equipment", methods=["GET", "POST"])
def equipment_form():
    if request.method == "POST":
        equipment = Equipment(
            name=request.form["name"],
            category=request.form.get("category"),
            cost=float(request.form["cost"]),
        )
        db.session.add(equipment)
        db.session.commit()
        flash("Equipment record saved successfully.", "success")
        return redirect(url_for("forms.equipment_form"))
    return render_template("equipment_form.html")


@forms_bp.route("/infrastructure", methods=["GET", "POST"])
def infrastructure_form():
    if request.method == "POST":
        infrastructure = Infrastructure(
            infra_type=request.form["infra_type"],
            description=request.form.get("description"),
            cost=float(request.form["cost"]),
        )
        db.session.add(infrastructure)
        db.session.commit()
        flash("Infrastructure record saved successfully.", "success")
        return redirect(url_for("forms.infrastructure_form"))
    return render_template("infrastructure_form.html")


@forms_bp.route("/other-expenses", methods=["GET", "POST"])
def other_expense_form():
    if request.method == "POST":
        expense = OtherExpense(
            description=request.form["description"],
            cost=float(request.form["cost"]),
        )
        db.session.add(expense)
        db.session.commit()
        flash("Other expense record saved successfully.", "success")
        return redirect(url_for("forms.other_expense_form"))
    return render_template("other_expense_form.html")
