# Healthcare Cost and Billing Analysis System

Flask + MySQL application for collecting healthcare billing inputs and generating category-wise analysis dashboards.

## Features
- Input forms for patient, doctor, employee, equipment, infrastructure, and other expense data.
- MySQL-backed schema with `patients.doctor_id` foreign key to `doctors.doctor_id`.
- Modular analysis functions for:
  - cost aggregation
  - billing transparency
  - anomaly detection (z-score)
- Dashboard with Plotly cost chart, patient inflow/discharge chart, and anomaly summaries.

## Setup
1. Create MySQL schema:
   ```bash
   mysql -u root -p < schema.sql
   ```
2. Install dependencies:
   ```bash
   pip install -r requirements.txt
   ```
3. Configure environment variable if needed:
   ```bash
   export DATABASE_URL='mysql+pymysql://root:password@localhost:3306/healthcare_billing'
   ```
4. Run app:
   ```bash
   python run.py
   ```

## Routes
- `/` home
- `/patients`
- `/doctors`
- `/employees`
- `/equipment`
- `/infrastructure`
- `/other-expenses`
- `/dashboard` (cost + patient flow analysis)
