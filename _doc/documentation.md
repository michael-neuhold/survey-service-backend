# Survey Survice

## Idea
Within the CLC project a prototype for a survey platform (similar to Doodle) is implemented. For this purpose, the created survey templates as well as the corresponding answers are created in the form of JSON documents in a MongoDB. For simple metadata and user data, a Postgres database is also used. Spring Boot is used as the backend technology. Deployment is targeted via Google Cloud (in combination with [spring-cloud-gcp](https://spring.io/projects/spring-cloud-gcp)). The backend provides a REST API, which can be accessed from a simple React Client.

## Tech Stack
- Kotlin
- Maven
- Spring Boot
- Google Cloud Platform
- Postgres
- MongoDB Atlas
- Terraform

## Architecture


![architecture](./architecture.svg)


## Automated Infrastructure
As part of the project, we also addressed the issue of infrastructure as code. As a technology we have choosen [Terraform (Automate Infrastructure on Any Cloud)](https://www.terraform.io/), because it is applicable to several cloud providers. For this purpose, a `main.tf` file was created in the backend repository folder `infrastructure`, which describes the provider configuration and the resources in a declarative way. It was possible to automate all except three of the steps for creating the infrastructure. You still have to create a `Google Cloud Project`, enable the `Secret Manager` and enable the `Cloud SQL Admin API` manually. The resources were configured consistently with terraform variables to achieve the highest possible maintainability. Care was taken to ensure that **no** secrets were pushed into the repository. Secret variables can be set by environment variables.

- Provider: Google
- Resources:
  - App Engine
  - Postgres Instance
  - Postgres DB Prod and Dev
  - Postgres DB User
  - Secret Manager
  - Secrets for Postgres and Mongo DB
  - IAM Service Account role assignment

### Terraform Setup

![w:1000000](./terraform-workflow.svg)

### CLI
Changes to the infrastructure (resource description in `main.tf`) can be analyzed via `terraform plan` (outputs changes that have to be made to reach target infrastructure) and applied via `terraform apply` (changes cloud infrastructure).

## Reliability
Services in the app engine can only be deployed in a selected region. If multiple instances are launched at the same time (as in our configuration), they are located in different zones of this region. 

The Postgres instance for the user data was configured to be available in a region with a `primary and a secondary zone`. This allows `automatic failover` to the secondary zone. In addition, daily backups are performed.

In this project MongoDB Atlas - a cloud native `NoSQL` database - was used. This provides `3 different models (Serverless, Dedicated, Shared)`, whereby only the Shared variant can be used free of charge. However, this should only be used for development and not for productive operation. In this project the shared variant was used with daily backups. 
The free tier already consists of a `three-node replica set`, which ensures high availability and reliability (see image below). 
When this application goes live, it would be switched to the Dedicated variant, which provides features such as elastic scalability and multi-cloud, `multi-region and advanced data distribution`. In addition, backup and retention policies can be set. 

<figure>
  <img src='mongodb_dev_cluster_architecture.png'
      alt='mongodb_dev_cluster_architecture'
      width='500px' />
  <figcaption>MongoDB Atlas (dev) cluster architecture, consisting of three nodes.</figcaption>
</figure>

## Scalability

### Persistance

As already mentioned in [Reliability](#reliability) our solution uses `MongoDB Atlas` to persist the application data. 
Atlas is available in three different subscription plans that collectively cover all use cases and volumes. 
The table below compares the most important features and capabilities of the three subscription plans.

|   | ![serverless](./MongoDB_Atlas/serverless.svg) Serverless | ![dedicated](./MongoDB_Atlas/dedicated.svg) Dedicated | ![shared](./MongoDB_Atlas/shared.svg) Shared |
|---|---|---|---|
| Usecase | workloads with variable traffic (development & testing) | workloads with consistent traffic (production) | learning & exploring |
| Pricing | consumption based | tier based | tier based (includes free tier) |
| Autoscaling <!-- = 'Elastic scalability' --> | :white_check_mark: compute & storage (seamless) | :white_check_mark: compute & storage (highly configurable) | - |
| Uptime SLA | - | :white_check_mark: 99.995% | - |
| Backups | :white_check_mark: twice per day | :white_check_mark: advanced configuration <!-- Configurable snapshot and retention policies; On-demand snapshots; Point-in-time recovery --> | :white_check_mark: daily (except free tier) |
| Multi-region <!-- advanced data distribution --> | coming later | :white_check_mark: | - |

The `Shared` plan (free tier) is capable enough for development prototypes and proofs of concept. 
It is not suitable for applications running in production, because of the low memory and throughput constraints. 

The `Serverless` plan is best suited for small businesses or applications with highly varying/volatile workloads, because of the seamless (configuration free) autoscaling and the consuption based pricing. 

The `Dedicated` plan is aimed at larger businesses that have consistently high loads and require additional isolation from other businesses/applications. What really sets this plan apart is the extreme flexibility. 
Some of the additional features:
- Uptime SLA: 99.995%
- manual vertical scaling & horizontal autoscaling
- highly configurable backup
  - configurable snapshot and retention policies
  - on-demand snapshots
  - point-in-time recovery
- multi-region and advanced data distribution (sharding)

---

For the sake of experimentation we also employ a `PostgreSQL` database for storing user information. 
Traditional relational databases offer very little in terms of scalability compared to NoSQL databases. 
The only adjustable parameter to increase compute capabilities is the VM-tier, which limits us to vertical scaling. 
This is associated with several disadvantages: Vertical scaling 'quickly' reaches a limit beyond which further scaling is impossible, and these 'extreme' VMs are also quite costly.