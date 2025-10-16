package com.clinix.modules.user.domain;

import com.clinix.modules.user.domain.model.User;
import com.clinix.modules.user.application.query.readmodel.UserSummaryReadModel;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void save(User user);
    Optional<UserSummaryReadModel> findSummaryById(UUID id);
}
