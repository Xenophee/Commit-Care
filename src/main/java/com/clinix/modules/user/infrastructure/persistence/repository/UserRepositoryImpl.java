package com.clinix.modules.user.infrastructure.persistence.repository;


import com.clinix.modules.user.domain.UserRepository;
import com.clinix.modules.user.domain.model.User;
import com.clinix.modules.user.infrastructure.persistence.entity.UserEntity;
import com.clinix.modules.user.infrastructure.persistence.projection.DoctorInfo;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    private final UserQuery userQuery;

    @Inject
    public UserRepositoryImpl(UserQuery userQuery) {
        this.userQuery = userQuery;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = new UserEntity();
        userQuery.persist(userEntity);
    }

    @Override
    public Optional<UserInfo> findUserSummaryById(UUID id) {
        return userQuery.findUserInfoById(id);
    }

    @Override
    public Optional<DoctorInfo> findDoctorSummaryById(UUID id) {
        return userQuery.findDoctorInfoById(id);
    }
}





