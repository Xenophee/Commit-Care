package com.clinix.common.exception;

public enum ErrorCode {


    USER_NOT_FOUND("L'utilisateur n'a pas été trouvé."),


    NOT_FOUND("Elément non trouvé."),
    INVALID_IDENTIFIER("L'identifiant fourni est invalide."),
    INTERNAL_SERVER_ERROR("Une erreur interne est survenue.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
