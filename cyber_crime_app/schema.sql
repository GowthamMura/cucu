CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE crime_reports (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    crime_type TEXT NOT NULL,
    description TEXT NOT NULL,
    location TEXT NOT NULL,
    report_date TEXT NOT NULL,
    severity_level TEXT NOT NULL,
    created_at TEXT NOT NULL
);

-- Re-created on each dataset upload from Pandas
CREATE TABLE dataset_records (
    Case_ID TEXT,
    Crime_Type TEXT,
    Location TEXT,
    State TEXT,
    Year INTEGER,
    Victim_Age INTEGER,
    Severity_Level TEXT,
    Description TEXT
);
