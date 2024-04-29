**How to kickoff the keycloak**

**Step1: Installation:**

Ensure that you have docker and docker compose installed in your system

**Step2: Start the keycloak**

Run the following command in your terminal;
```bash
docker-compose up -d
```
This command will download the necessary Docker images and start the Keycloak and PostgreSQL containers in detached mode.

**Step 3: Access Keycloak Admin Console**

Once the containers are up and running, you can access the Keycloak Admin Console by navigating to http://localhost:8080 in your web browser. Log in with the

username
```bash
admin_username
```
password
```bash
admin_password
```
**Step 4: Configure Keycloak**

You can now configure Keycloak according to your requirements, including setting up realms, clients, users, and roles.

**Step 5: Clean Up**
To stop and remove the Keycloak and PostgreSQL containers, run the following command:
```bash
docker-compose down
```
This will stop and remove the containers, but it will retain the data stored in the PostgreSQL volume by default.