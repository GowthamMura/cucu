# Cyber Crime Data Analysis and Visualization Web Application

A complete Flask-based final year project for cyber crime data analysis.

## Tech Stack
- **Frontend:** HTML, CSS, JavaScript, Bootstrap 5
- **Backend:** Python Flask
- **Database:** SQLite (compatible with MySQL schema style)
- **Data Analysis:** Pandas, NumPy
- **Visualization:** Chart.js

## Folder Structure
```text
cyber_crime_app/
├── app.py
├── cyber_crime.db                # auto-created on first run
├── schema.sql
├── uploads/                      # uploaded CSV files
├── data/
│   └── cyber_crime_sample_200.csv
├── static/
│   ├── css/style.css
│   └── js/main.js
└── templates/
    ├── base.html
    ├── login.html
    ├── dashboard.html
    ├── upload_dataset.html
    ├── crime_search.html
    ├── crime_report.html
    └── data_filter.html
```

## Features
1. **Login System** with session handling (`admin/admin123` default)
2. **Dataset Upload** (CSV), server-side storage, Pandas loading, table preview
3. **Crime Search Form** by crime type, location, year, case ID
4. **Crime Report Form** to submit new incidents into database
5. **Data Filter Form** by year/category/state-city/severity
6. **Visualization Dashboard**: crime type, yearly trend, location chart, severity chart
7. **Dashboard Metrics**: total crimes, most common crime, latest year, trend direction

## Dataset Schema
Expected CSV columns:
- `Case_ID`
- `Crime_Type`
- `Location`
- `State`
- `Year`
- `Victim_Age`
- `Severity_Level`
- `Description`

## Run Instructions
```bash
cd cyber_crime_app
pip install flask pandas numpy
python app.py
```
Then open: `http://127.0.0.1:5000`

## Notes on Analysis
Pandas is used to:
- Validate and normalize uploaded dataset columns
- Store records into SQLite (`dataset_records`) using `to_sql`
- Compute dashboard metrics and aggregations for charts
- Filter/search records with form inputs
