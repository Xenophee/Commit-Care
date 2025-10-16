package com.clinix.modules.user.infrastructure.web.dto;

import java.util.UUID;

public record UserDTO(
        UUID id,
        String email,
        String firstname,
        String lastname
) {
}
