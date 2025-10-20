package com.clinix.modules.user.domain;

import com.clinix.modules.user.domain.model.User;
import com.clinix.modules.user.application.query.readmodel.UserSummaryReadModel;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo2;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void save(User user);
    Optional<UserInfo2> findSummaryById(UUID id);
}
