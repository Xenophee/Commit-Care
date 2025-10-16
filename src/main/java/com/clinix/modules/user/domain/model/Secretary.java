package com.clinix.modules.user.domain.model;

import com.clinix.modules.user.domain.valueobject.Email;

import java.util.UUID;

public final class Secretary extends User {

    public Secretary(UUID id, Email email, String passwordHash, String firstname, String lastname) {
        super(id, email, passwordHash, firstname, lastname);
    }
}
