variable "project-id" {
  type        = string
  description = "Google Cloud Platform Project ID"
}

variable "app-location" {
  type        = string
  description = "Google Cloud App Engine App Location"
}

variable "postgres-instance-tier" {
  type        = string
  description = "Google Cloud App Engine Postgres Instance Tier"
}

variable "postgres-instance-location" {
  type        = string
  description = "Google Cloud App Engine Postgres Instance Location"
}

variable "postgres-instance-name" {
  type        = string
  description = "Google Cloud App Engine Postgres Instance Name"
}

variable "postgres-instance-version" {
  type        = string
  description = "Google Cloud App Engine Postgres Instance Version"
}

variable "postgres-instance-user" {
  type        = string
  description = "Google Cloud App Engine Postgres Instance User"
}

variable "postgres-instance-password" {
  type        = string
  description = "Google Cloud App Engine Postgres Instance Password"
}

variable "postgres-instance-prod-db-name" {
  type        = string
  description = "Google Cloud App Engine Postgres Prod DB Name"
}

variable "postgres-instance-dev-db-name" {
  type        = string
  description = "Google Cloud App Engine Postgres Dev DB Name"
}

variable "mongo-db-dev-instance-password" {
  type        = string
  description = "Mongo Atlas Dev DB Password"
}

variable "mongo-db-prod-instance-password" {
  type        = string
  description = "Mongo Atlas Prod DB Password"
}

variable "secret-accessor-role" {
  type        = string
  description = "Google Cloud IAM Secret Accessor Role"
}

variable "project-service-account" {
  type        = string
  description = "Google Cloud IAM Service Account"
}

variable "postgres-instance-secret-id" {
  type        = string
  description = "Google Cloud Secret Manager Postgres Secret ID"
}

variable "mongo-db-dev-instance-secret-id" {
  type        = string
  description = "Google Cloud Secret Manager Mongo DB Dev Secret ID"
}

variable "mongo-db-prod-instance-secret-id" {
  type        = string
  description = "Google Cloud Secret Manager Mongo DB Prod Secret ID"
}