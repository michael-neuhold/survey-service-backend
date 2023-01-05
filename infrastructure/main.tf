# MANUAL STEPS:
## Create Google Cloud Project
## Enable Secret Manager in Google Cloud Portal
## Enable Cloud SQL Admin API

provider "google" {
  project     = var.project-id
}

#===================
# Setup App Engine

resource "google_app_engine_application" "app" {
  project     = var.project-id
  location_id = var.app-location
}

#===================
# Setup Postgres Instance

resource "google_sql_database_instance" "postgres-instance" {
  name             = var.postgres-instance-name
  database_version = var.postgres-instance-version
  region           = var.postgres-instance-location

  settings {
    tier = var.postgres-instance-tier
    location_preference {
        zone = var.postgres-instance-zone
        secondary_zone = var.postgres-instance-secondary-zone
    }
  }

  deletion_protection = false # should not be done - only for demo
}

#===================
# Configure 2 Databases in Postgres Instance above

resource "google_sql_database" "postgres-db-prod" {
  name     = var.postgres-instance-prod-db-name
  instance = google_sql_database_instance.postgres-instance.name
}

resource "google_sql_database" "postgres-db-dev" {
  name     = var.postgres-instance-dev-db-name
  instance = google_sql_database_instance.postgres-instance.name
}

#===================
# Configure DB User for Postgres

resource "google_sql_user" "user" {
  name     = var.postgres-instance-user
  instance = google_sql_database_instance.postgres-instance.name
  password = google_secret_manager_secret_version.postgres-instance-secret-password.secret_data
}

#===================
# Prepare secret key-value pairs

resource "google_secret_manager_secret" "postgres-instance-secret" {
  secret_id = var.postgres-instance-secret-id

  replication {
    automatic = true
  }
}

resource "google_secret_manager_secret" "mongo-db-dev-instance-secret" {
  secret_id = var.mongo-db-dev-instance-secret-id

  replication {
    automatic = true
  }
}

resource "google_secret_manager_secret" "mongo-db-prod-instance-secret" {
  secret_id = var.mongo-db-prod-instance-secret-id

  replication {
    automatic = true
  }
}

#===================
# Set secret values

resource "google_secret_manager_secret_version" "postgres-instance-secret-password" {
  secret = google_secret_manager_secret.postgres-instance-secret.id
  secret_data = var.postgres-instance-password
}

resource "google_secret_manager_secret_version" "mongo-db-dev-instance-secret-password" {
  secret = google_secret_manager_secret.mongo-db-dev-instance-secret.id
  secret_data = var.mongo-db-dev-instance-password
}

resource "google_secret_manager_secret_version" "mongo-db-prod-instance-secret-password" {
  secret = google_secret_manager_secret.mongo-db-prod-instance-secret.id
  secret_data = var.mongo-db-prod-instance-password
}

#===================
# IAM -> set role for service account to access secrets in secret manager
# Otherwise it is not possible to access secrets while deploying

resource "google_project_iam_binding" "service-account-role-assignment" {
  project = var.project-id
  role    = var.secret-accessor-role

  members = [
    var.project-service-account,
  ]
}