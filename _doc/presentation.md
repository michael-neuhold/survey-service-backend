---
marp: true
theme: default
paginate: true
---

<!--![bg left:40% 80%](https://marp.app/assets/marp.svg)-->

# **Survey Service**

Powered by Julian Jany and Michael Neuhold

---

# About the project
- Prototype for survey platform like Doodle
- Survey represented as JSON Document
- Users can participate
- Survey owner can evaluate results
- Course relevance:
  - Google Cloud Platfrom
  - NoSQL
  - SQL 
  - Scaleability & Reliability
  - Infrastructure as Code
  - Costs

---

# Architecture

![w:1000000](./architecture.svg)

---

# Tech Stack
- Kotlin
- Maven
- Spring Boot
- Google Cloud Platform
- Postgres
- MongoDB Atlas
- Terraform
---

# Automated Infrastructure
- [Terraform (Automate Infrastructure on Any Cloud)](https://www.terraform.io/)
- Provider: Google
- Resources:
  - App Engine
  - Postgres Instance
  - Postgres DB Prod and Dev
  - Postgres DB User
  - Secret Manager
  - Secrets for Postgres and Mongo DB
  - IAM Service Account role assignment
---

![w:1000000](./terraform-workflow.svg)

---

# Scalability

---

# Reliability
- App Engine
  - Single region
  - Multiple instances -> multiple zones
- Postgres DB (User Data)
  - Single region
  - Primary and secondary zone for `automatic failover`
- MongoDB Atlas
  - `Shared` Instance (Only for development)
  - In production switch to `Dedicated` deployment
    - elastic scalability
    - multi-region
    - advanced data distribution

---

# NoSQL

---

# Replication

---

# Costs

---

# Demo Time