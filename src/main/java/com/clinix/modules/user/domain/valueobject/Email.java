package com.clinix.modules.user.domain.valueobject;

public record Email(String email) {
    public Email {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email invalide");
        }
    }

    public String value() {
        return email;
    }
}
