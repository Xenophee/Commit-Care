package com.clinix.common.valueobject;


import com.clinix.common.exception.InvalidIdentifierException;

import java.util.UUID;

public record Uuid(UUID value) {

    public Uuid(String id) {
        this(parseUUID(id));
    }

    private static UUID parseUUID(String id) {
        try {
            return UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new InvalidIdentifierException(id);
        }
    }

}
