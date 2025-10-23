package com.clinix.modules.user.infrastructure.persistence.projection;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.UUID;

@RegisterForReflection
public class UserInfo {

    private UUID id;
    private String email;
    private String firstname;
    private String lastname;

    public UserInfo(UUID id, String email, String firstname, String lastname) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}

