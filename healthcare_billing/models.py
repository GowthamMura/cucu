from healthcare_billing.extensions import db


class Doctor(db.Model):
    __tablename__ = "doctors"

    doctor_id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(120), nullable=False)
    specialization = db.Column(db.String(120), nullable=False)
    consultation_fee = db.Column(db.Float, nullable=False, default=0.0)

    patients = db.relationship("Patient", back_populates="doctor", lazy=True)


class Patient(db.Model):
    __tablename__ = "patients"

    patient_id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(120), nullable=False)
    age = db.Column(db.Integer, nullable=False)
    gender = db.Column(db.String(30), nullable=False)
    diagnosis = db.Column(db.String(255), nullable=True)
    billed_amount = db.Column(db.Float, nullable=False, default=0.0)
    admission_date = db.Column(db.Date, nullable=True)
    discharge_date = db.Column(db.Date, nullable=True)
    is_discharged = db.Column(db.Boolean, nullable=False, default=False)
    doctor_id = db.Column(db.Integer, db.ForeignKey("doctors.doctor_id"), nullable=False)

    doctor = db.relationship("Doctor", back_populates="patients")


class Employee(db.Model):
    __tablename__ = "employees"

    employee_id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(120), nullable=False)
    role = db.Column(db.String(120), nullable=False)
    salary = db.Column(db.Float, nullable=False, default=0.0)


class Equipment(db.Model):
    __tablename__ = "equipment"

    equipment_id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(120), nullable=False)
    category = db.Column(db.String(120), nullable=True)
    cost = db.Column(db.Float, nullable=False, default=0.0)


class Infrastructure(db.Model):
    __tablename__ = "infrastructure"

    infra_id = db.Column(db.Integer, primary_key=True)
    infra_type = db.Column(db.String(120), nullable=False)
    description = db.Column(db.String(255), nullable=True)
    cost = db.Column(db.Float, nullable=False, default=0.0)


class OtherExpense(db.Model):
    __tablename__ = "other_expenses"

    expense_id = db.Column(db.Integer, primary_key=True)
    description = db.Column(db.String(255), nullable=False)
    cost = db.Column(db.Float, nullable=False, default=0.0)
