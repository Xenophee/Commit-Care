package com.clinix.modules.user.infrastructure.persistence.repository;

import com.clinix.modules.user.infrastructure.persistence.entity.UserEntity;
import com.clinix.modules.user.infrastructure.persistence.projection.DoctorInfo;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserQuery implements PanacheRepository<UserEntity> {

    public Optional<UserInfo> findUserInfoById(UUID id) {
        return find("id", id)
                .project(UserInfo.class)
                .firstResultOptional();
    }

    public Optional<DoctorInfo> findDoctorInfoById(UUID id) {
        return find("id", id)
                .project(DoctorInfo.class)
                .firstResultOptional();
    }
}
