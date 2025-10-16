package com.clinix.modules.user.application.query.readmodel;

import java.util.UUID;

public record UserSummaryReadModel(
        UUID id,
        String email,
        String firstname,
        String lastname
) {}

