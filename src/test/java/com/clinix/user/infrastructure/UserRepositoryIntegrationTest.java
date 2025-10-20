package com.clinix.user.infrastructure;


import com.clinix.PostgresDBTestResource;
import com.clinix.modules.user.infrastructure.persistence.entity.UserEntity;
import com.clinix.modules.user.application.query.readmodel.UserSummaryReadModel;
import com.clinix.modules.user.infrastructure.persistence.repository.UserQuery;
import com.clinix.modules.user.infrastructure.persistence.repository.UserRepositoryImpl;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@QuarkusTestResource(PostgresDBTestResource.class)
public class UserRepositoryIntegrationTest {

    @Inject
    Flyway flyway;

    @Inject
    UserRepositoryImpl userRepository;

    @Inject
    UserQuery userQuery;


    @BeforeEach
    void beforeEach() {
        flyway.clean();
        flyway.migrate();
    }

    /*@Test
    @Transactional
    void testFindSummaryById() {
        UserEntity entity = new UserEntity()
                .setEmail("test@example.com")
                .setPassword("securepassword")
                .setFirstname("John")
                .setLastname("Doe");
        userQuery.persist(entity);

        UUID id = entity.getId(); // Récupère l'id généré

        Optional<UserSummaryReadModel> userSummary = userRepository.findSummaryById(id);

        assertThat(userSummary).isPresent();
        UserSummaryReadModel summary = userSummary.get();

        assertThat(summary.id()).isEqualTo(id);
        assertThat(summary.email()).isEqualTo("test@example.com");
        assertThat(summary.firstname()).isEqualTo("John");
        assertThat(summary.lastname()).isEqualTo("Doe");
    }*/
}
