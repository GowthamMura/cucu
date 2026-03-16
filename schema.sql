CREATE DATABASE IF NOT EXISTS healthcare_billing;
USE healthcare_billing;

CREATE TABLE IF NOT EXISTS doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    specialization VARCHAR(120) NOT NULL,
    consultation_fee DECIMAL(12,2) NOT NULL DEFAULT 0.00
);

CREATE TABLE IF NOT EXISTS patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(30) NOT NULL,
    diagnosis VARCHAR(255),
    billed_amount DECIMAL(12,2) NOT NULL DEFAULT 0.00,
    admission_date DATE,
    discharge_date DATE,
    is_discharged BOOLEAN NOT NULL DEFAULT FALSE,
    doctor_id INT NOT NULL,
    CONSTRAINT fk_patient_doctor FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id)
);

CREATE TABLE IF NOT EXISTS employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    role VARCHAR(120) NOT NULL,
    salary DECIMAL(12,2) NOT NULL DEFAULT 0.00
);

CREATE TABLE IF NOT EXISTS equipment (
    equipment_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    category VARCHAR(120),
    cost DECIMAL(12,2) NOT NULL DEFAULT 0.00
);

CREATE TABLE IF NOT EXISTS infrastructure (
    infra_id INT AUTO_INCREMENT PRIMARY KEY,
    infra_type VARCHAR(120) NOT NULL,
    description VARCHAR(255),
    cost DECIMAL(12,2) NOT NULL DEFAULT 0.00
);

CREATE TABLE IF NOT EXISTS other_expenses (
    expense_id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    cost DECIMAL(12,2) NOT NULL DEFAULT 0.00
);
