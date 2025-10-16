package com.clinix.modules.user.infrastructure.web.dto;

public record CreateSecretaryRequest(
        String email,
        String password,
        String firstname,
        String lastname
) {
}
