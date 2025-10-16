package com.clinix.common.exception.mapper;

import com.clinix.common.exception.InvalidIdentifierException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class InvalidIdentifierExceptionMapper implements ExceptionMapper<InvalidIdentifierException> {

    @Override
    public Response toResponse(InvalidIdentifierException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(java.util.Map.of("error", exception.getMessage()))
                .build();
    }
}
