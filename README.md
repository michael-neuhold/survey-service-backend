# gcp-survey-service-backend

## Secret Manager
- Enable Secret Manager Service in GCP
- Add new secret called "survey-mongo-db-password"
- Paste mongo prod password as value
- Generate default login for secret manager: `gcloud auth application-default login`
- Execution with spring prod profile connects to prod db
- In GCP -> IAM -> <projectname>@appspot.gserviceacount.com -> add new role "Secret Manager Secret Accessor" otherwise secret can not be read

## Todos:
- [x] Create Dev Mongo Instance
- [x] Julian: Create Document Types Survey and Response [see this](./_doc)
- [x] Julian: Create Business Logic CRUD operations + analytics
- [x] Michi: Create Postgres Db in GCP
- [x] Michi: Create Dev Postgres Instance
- [x] Michi: Create Add Swagger Doc
- [x] Michi: Frontend Project deployment

===
Fragen:
- [ ] Michi: Automated Infrastructue Provisioning/(Infrastructure-as-Code). Wie wurde im vorliegenden Projekt Automated Infrastructure Provisioning berücksichtigt? 
- [ ] Julian: Skalierbarkeit. Wie wurde im vorliegenden Projekt Skalierbarkeit berücksichtigt?
- [ ] Michi: Ausfallssicherheit.  Wie wurde im vorliegenden Projekt Ausfallssicherheit berücksichtigt?
- [ ] Julian: NoSql. Welchen Beitrag leistet NoSql in der vorliegenden Problemstellung?
- [ ] Julian: Replikation. Wo nutzen Sie im gegenständlichen Projekt Daten-Replikation?
- [ ] Michi & Julian: Kosten. Welche Kosten verursacht Ihre Lösung? Welchen monetären Vorteil hat diese Lösung gegenüber einer Nicht-Cloud-Lösung?
Frontend:
- [ ] Julian: Show Evaluations on /survey (author == current user)
- [ ] Michi: Show Questions + Answers if user already answered
- [ ] Julian: Show Form (Dropdown, Radio)