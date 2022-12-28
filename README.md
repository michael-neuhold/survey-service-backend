# gcp-survey-service-backend

## Secret Manager
- Enable Secret Manager Service in GCP
- Add new secret called "survey-mongo-db-password"
- Paste mongo prod password as value
- Generate default login for secret manager: `gcloud auth application-default login`
- Execution with spring prod profile connects to prod db
- In GCP -> IAM -> <projectname>@appspot.gserviceacount.com -> add new role "Secret Manager Secret Accessor" otherwise secret can not be read

## Todos:
- [ ] Create Document Types Survey and Response [see this](./_doc)
- [ ] Create Business Logic CRUD operations + analytics
- [x] Create Dev Mongo Instance 
- [ ] Create Postgres Db in GCP
- [ ] Create Dev Postgres Instance
- [ ] Create Add Swagger Doc
- [ ] Frontend Project