import json

import plotly
import plotly.express as px
from flask import Blueprint, render_template

from healthcare_billing.services.analysis import (
    aggregate_costs,
    billing_transparency,
    detect_anomalies,
)

dashboard_bp = Blueprint("dashboard", __name__)


@dashboard_bp.route("/dashboard")
def dashboard():
    aggregated = aggregate_costs()
    breakdown_df = billing_transparency()
    anomalies = detect_anomalies()

    fig = px.pie(
        breakdown_df,
        values="cost",
        names="category",
        title="Healthcare Cost Breakdown",
        hole=0.35,
    )
    chart_json = json.dumps(fig, cls=plotly.utils.PlotlyJSONEncoder)

    return render_template(
        "dashboard.html",
        total_cost=aggregated["total_healthcare_cost"],
        breakdown=aggregated["category_breakdown"],
        anomalies=anomalies,
        chart_json=chart_json,
        transparency_table=breakdown_df.to_dict(orient="records"),
    )
