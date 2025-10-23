package com.clinix.modules.user.domain;

import com.clinix.modules.user.domain.model.User;
import com.clinix.modules.user.infrastructure.persistence.projection.DoctorInfo;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void save(User user);
    Optional<UserInfo> findUserSummaryById(UUID id);
    Optional<DoctorInfo> findDoctorSummaryById(UUID id);
}
