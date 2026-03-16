import json

import plotly
import plotly.express as px
from flask import Blueprint, render_template

from healthcare_billing.services.analysis import (
    aggregate_costs,
    billing_transparency,
    detect_anomalies,
    patient_flow_summary,
)

dashboard_bp = Blueprint("dashboard", __name__)


@dashboard_bp.route("/dashboard")
def dashboard():
    aggregated = aggregate_costs()
    breakdown_df = billing_transparency()
    anomalies = detect_anomalies()
    patient_flow = patient_flow_summary()

    cost_fig = px.pie(
        breakdown_df,
        values="cost",
        names="category",
        title="Healthcare Cost Breakdown",
        hole=0.35,
    )
    cost_chart_json = json.dumps(cost_fig, cls=plotly.utils.PlotlyJSONEncoder)

    flow_fig = px.bar(
        x=["Came In", "Discharged"],
        y=[patient_flow["came_in"], patient_flow["discharged"]],
        text=[patient_flow["came_in"], patient_flow["discharged"]],
        title="Patient Flow Analysis",
        labels={"x": "Patient Status", "y": "Count"},
    )
    flow_fig.update_traces(marker_color=["#2563eb", "#16a34a"], textposition="outside")
    flow_chart_json = json.dumps(flow_fig, cls=plotly.utils.PlotlyJSONEncoder)

    return render_template(
        "dashboard.html",
        total_cost=aggregated["total_healthcare_cost"],
        breakdown=aggregated["category_breakdown"],
        anomalies=anomalies,
        cost_chart_json=cost_chart_json,
        flow_chart_json=flow_chart_json,
        transparency_table=breakdown_df.to_dict(orient="records"),
        patient_flow=patient_flow,
    )
