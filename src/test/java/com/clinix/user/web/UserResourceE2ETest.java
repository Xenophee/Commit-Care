package com.clinix.user.web;


import com.clinix.PostgresDBTestResource;
import com.clinix.modules.user.infrastructure.web.UserResource;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.flywaydb.core.Flyway;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(UserResource.class)
@QuarkusTestResource(PostgresDBTestResource.class)
public class UserResourceE2ETest {

    @Inject
    Flyway flyway;

    @BeforeEach
    void beforeEach() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    void shouldGetUserById() {

        String uuid = "005d5657-3a8f-4132-a038-518a4bf7896f";

        given()
                .when().get("/" + uuid)
                .then()
                .statusCode(200)
                .body("id", CoreMatchers.is(uuid))
                .body("email", CoreMatchers.is("hugo.tartempion@hospital.test"))
                .body("firstname", CoreMatchers.is("Hugo"))
                .body("lastname", CoreMatchers.is("Tartempion"));
    }
}
