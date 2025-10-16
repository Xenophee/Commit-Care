package com.clinix.common;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;


@Path("/")
public class HomeController {

    @Operation(hidden = true)
    @GET
    public Response redirectForSwaggerDoc() {
        return Response.status(Response.Status.MOVED_PERMANENTLY)
                .header("Location", "/q/swagger-ui")
                .build();
    }
}
