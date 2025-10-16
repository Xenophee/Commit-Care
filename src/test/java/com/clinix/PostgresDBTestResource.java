package com.clinix;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;

public class PostgresDBTestResource implements QuarkusTestResourceLifecycleManager {

    private static final PostgreSQLContainer<?> POSTGRES_CONTAINER = new PostgreSQLContainer<>("postgres:17")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");


    @Override
    public Map<String, String> start() {
        POSTGRES_CONTAINER.start();

        Map<String, String> config = new HashMap<>();
        config.put("quarkus.datasource.jdbc.url", POSTGRES_CONTAINER.getJdbcUrl());
        config.put("quarkus.datasource.username", POSTGRES_CONTAINER.getUsername());
        config.put("quarkus.datasource.password", POSTGRES_CONTAINER.getPassword());

        config.put("quarkus.hibernate-orm.database.generation", "none"); // on laisse Flyway gérer la DB

        return config;
    }

    @Override
    public void stop() {
        POSTGRES_CONTAINER.stop();
    }
}
