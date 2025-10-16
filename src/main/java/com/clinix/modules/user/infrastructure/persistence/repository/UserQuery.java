package com.clinix.modules.user.infrastructure.persistence.repository;

import com.clinix.modules.user.infrastructure.persistence.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserQuery implements PanacheRepository<UserEntity> {

    @PersistenceContext
    EntityManager em;

    public Optional<Tuple> findSummaryById(UUID id) {
        String jpql = """
                    SELECT user.id as id, user.email as email, user.firstname as firstname, user.lastname as lastname
                    FROM UserEntity user
                    WHERE user.id = :id
                """;

        TypedQuery<Tuple> query = em.createQuery(jpql, Tuple.class);
        query.setParameter("id", id);

        return query.getResultStream().findFirst();
    }

}
