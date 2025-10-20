package com.clinix.modules.user.infrastructure.persistence.projection;

import java.util.UUID;


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

    // Getters
    public UUID getId() { return id; }
    public String getEmail() { return email; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
}

