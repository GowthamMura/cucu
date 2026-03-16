from __future__ import annotations

import numpy as np
import pandas as pd

from healthcare_billing.models import (
    Doctor,
    Employee,
    Equipment,
    Infrastructure,
    OtherExpense,
    Patient,
)


CATEGORY_MAP = {
    "patient": (Patient, "billed_amount"),
    "doctor": (Doctor, "consultation_fee"),
    "employee": (Employee, "salary"),
    "equipment": (Equipment, "cost"),
    "infrastructure": (Infrastructure, "cost"),
    "others": (OtherExpense, "cost"),
}


def _extract_values(model, field: str) -> pd.Series:
    values = [getattr(row, field) for row in model.query.all()]
    if not values:
        return pd.Series(dtype="float64")
    return pd.Series(values, dtype="float64")


def aggregate_costs() -> dict:
    totals = {}
    for category, (model, field) in CATEGORY_MAP.items():
        totals[category] = float(_extract_values(model, field).sum())

    total_healthcare_cost = float(sum(totals.values()))
    return {
        "total_healthcare_cost": total_healthcare_cost,
        "category_breakdown": totals,
    }


def billing_transparency() -> pd.DataFrame:
    aggregated = aggregate_costs()
    total = aggregated["total_healthcare_cost"]

    rows = []
    for category, value in aggregated["category_breakdown"].items():
        percentage = (value / total * 100) if total else 0.0
        rows.append({"category": category, "cost": value, "percentage": round(percentage, 2)})

    return pd.DataFrame(rows)


def detect_anomalies(z_threshold: float = 2.0) -> dict:
    anomalies = {}

    for category, (model, field) in CATEGORY_MAP.items():
        series = _extract_values(model, field)

        if series.empty or len(series) == 1 or np.isclose(series.std(ddof=0), 0.0):
            anomalies[category] = []
            continue

        mean = series.mean()
        std = series.std(ddof=0)
        z_scores = (series - mean) / std

        category_anomalies = []
        for idx, (value, z_score) in enumerate(zip(series.tolist(), z_scores.tolist()), start=1):
            if abs(z_score) >= z_threshold:
                category_anomalies.append(
                    {
                        "record_index": idx,
                        "amount": round(float(value), 2),
                        "z_score": round(float(z_score), 2),
                    }
                )

        anomalies[category] = category_anomalies

    return anomalies


def patient_flow_summary() -> dict:
    total_patients = Patient.query.count()
    discharged_patients = Patient.query.filter_by(is_discharged=True).count()
    currently_admitted = total_patients - discharged_patients

    return {
        "came_in": total_patients,
        "discharged": discharged_patients,
        "currently_admitted": currently_admitted,
    }
