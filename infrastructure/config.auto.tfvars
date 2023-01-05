project-id = "clc3-terraform-iac"
app-location = "europe-west6"

postgres-instance-tier = "db-f1-micro"
postgres-instance-version = "POSTGRES_14"
postgres-instance-location = "europe-west6"
postgres-instance-user = "postgres"
postgres-instance-name = "clc3-terraform-iac-postgres"
postgres-instance-prod-db-name = "clc3-terraform-iac-postgres-prod"
postgres-instance-dev-db-name = "clc3-terraform-iac-postgres-dev"
postgres-instance-zone = "europe-west6-a"
postgres-instance-secondary-zone = "europe-west6-b"

secret-accessor-role = "roles/secretmanager.secretAccessor"
project-service-account = "serviceAccount:clc3-terraform-iac@appspot.gserviceaccount.com"

postgres-instance-secret-id = "postgres-instance-secret"
mongo-db-dev-instance-secret-id = "mongo-db-dev-instance-secret"
mongo-db-prod-instance-secret-id = "mongo-db-prod-instance-secret"