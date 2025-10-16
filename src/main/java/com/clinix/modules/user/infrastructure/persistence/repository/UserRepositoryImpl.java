package com.clinix.modules.user.infrastructure.persistence.repository;

import com.clinix.modules.user.domain.UserRepository;
import com.clinix.modules.user.domain.model.User;
import com.clinix.modules.user.infrastructure.persistence.entity.UserEntity;
import com.clinix.modules.user.infrastructure.persistence.mapper.UserMapper;
import com.clinix.modules.user.application.query.readmodel.UserSummaryReadModel;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    private final UserQuery userQuery;
    private final UserMapper mapper;

    public UserRepositoryImpl(UserQuery userQuery, UserMapper mapper) {
        this.userQuery = userQuery;
        this.mapper = mapper;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = new UserEntity();
        userQuery.persist(userEntity);
    }

    @Override
    public Optional<UserSummaryReadModel> findSummaryById(UUID id) {

        return userQuery.findSummaryById(id)
                .map(mapper::fromTuple);
    }
}
