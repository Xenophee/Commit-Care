package com.clinix.modules.user.application.command.writemodel;

public record CreateSecretaryCommand(
        String email,
        String password,
        String firstname,
        String lastname
) {
}
