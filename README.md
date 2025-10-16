# commit-cure

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/commit-cure-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and
  Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on
  it.
- Flyway ([guide](https://quarkus.io/guides/flyway)): Handle your database schema migrations
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes
  with Swagger UI
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus
  REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code
  for Hibernate ORM via the active record or the repository pattern
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)

### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)



_____________________________________________

### Endpoints

  
#### Authentification & gestion utilisateurs
- `POST /auth/login` → connexion (renvoie JWT)
- `POST /auth/register` → inscription
- `GET /users` → liste complète avec filtre par patient / docteurs [SECRETARY], liste filtrée [DOCTOR]
- `GET /users/{id}` → consulter un profil [SECRETARY, DOCTOR]
- `PUT /users/{id}` → mettre à jour profil complet [PATIENT], partiel [SECRETARY, DOCTOR]


#### Gestion des rôles
- `GET /roles` → liste des rôles [SECRETARY]
- `POST /user/{id}/roles` → assigner un rôle [SECRETARY]
- `DELETE /user/{id}/roles/{roleId}` → retirer un rôle [SECRETARY]


#### Rendez-vous
- `GET /appointments` → liste filtrée par type/date/docteur/patient [SECRETARY], liste personnelle filtrée par type/date/ docteur ou patient [DOCTOR, PATIENT]
- `POST /appointments` → créer un rendez-vous [PATIENT, DOCTOR, SECRETARY]
- `PUT /appointments/{id}` → modifier un rendez-vous [PATIENT, DOCTOR, SECRETARY]
- `DELETE /appointments/{id}` → annuler [PATIENT, DOCTOR, SECRETARY]


#### Maladies
- `GET /diseases` → liste des maladies [SECRETARY, DOCTOR]
- `GET /diseases/{id}` → détails d’une maladie [SECRETARY, DOCTOR]


🔐 Droits et contraintes par rôle

| Rôle          | Peut créer                     | Peut modifier | Peut consulter                |
| ------------- | ------------------------------ | ------------- | ----------------------------- |
| **Admin**     | Doctors, Secretaries, Patients | Tous          | Tous                          |
| **Secretary** | Patients                       | Patients      | Patients, Doctors             |
| **Doctor**    | –                              | Ses patients  | Ses patients, ses rendez-vous |
| **Patient**   | Lui-même                       | Son profil    | Ses infos, ses RDV            |
