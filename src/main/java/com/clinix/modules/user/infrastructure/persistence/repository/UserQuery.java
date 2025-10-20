package com.clinix.modules.user.infrastructure.persistence.repository;

import com.clinix.modules.user.infrastructure.persistence.entity.UserEntity;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo2;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
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

    public Optional<UserInfo2> findUserInfoById(UUID id) {
        return find(UserEntity.FIND_DOCTOR_BY_UUID, Parameters.with("id", id))
                .project(UserInfo2.class)
                .firstResultOptional()
                .map(userInfo2 -> {
                    UserInfo2.DoctorInfo doctorInfo = null;
                    if (userInfo2.getDoctor() != null) {
                        doctorInfo = new UserInfo2.DoctorInfo(
                                userInfo2.getDoctor().getOfficeNumber(),
                                userInfo2.getDoctor().getLicenseNumber()
                        );
                    }
                    return new UserInfo2(
                            userInfo2.getId(),
                            userInfo2.getEmail(),
                            userInfo2.getFirstname(),
                            userInfo2.getLastname(),
                            doctorInfo
                    );
                });
    }

    /*public Optional<UserEntity> findUserInfoById(UUID id) {
        return find(UserEntity.FIND_BY_UUID, Parameters.with("id", id))
                .firstResultOptional();
    }*/


    /*public Optional<UserInfo2> findUserInfoById(UUID id) {
        return find("id", id)
                .project(UserInfo2.class)
                .firstResultOptional();
    }*/


    /*public Optional<UserInfo> findUserInfoById(UUID id) {
        return find("id", id)
                .project(UserInfo.class)
                .firstResultOptional();
    }*/

}
