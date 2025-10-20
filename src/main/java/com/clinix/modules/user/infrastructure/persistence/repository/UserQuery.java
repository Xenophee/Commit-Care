package com.clinix.modules.user.infrastructure.persistence.repository;

import com.clinix.modules.user.infrastructure.persistence.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Tuple;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserQuery implements PanacheRepository<UserEntity> {

    private final EntityManager em;

    @Inject
    public UserQuery(EntityManager em) {
        this.em = em;
    }


    /*public Optional<UserEntity> findByUUID(UUID id) {
        return find(UserEntity.FIND_BY_UUID, id).firstResultOptional();
    }*/

    public Optional<Tuple> findSummaryById(UUID id) {
        return em.createNamedQuery(UserEntity.FIND_BY_UUID, Tuple.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst();
    }

}
