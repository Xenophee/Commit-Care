package com.clinix.common.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(ErrorCode message) {
        super(message.getMessage());
    }

    public NotFoundException() {
        super(ErrorCode.NOT_FOUND.getMessage());
    }
}
