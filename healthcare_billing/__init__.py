from flask import Flask

from healthcare_billing.extensions import db
from healthcare_billing.routes.dashboard import dashboard_bp
from healthcare_billing.routes.forms import forms_bp


def create_app() -> Flask:
    app = Flask(__name__)
    app.config.from_object("healthcare_billing.config.Config")

    db.init_app(app)

    app.register_blueprint(forms_bp)
    app.register_blueprint(dashboard_bp)

    with app.app_context():
        db.create_all()

    return app
