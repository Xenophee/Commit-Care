package com.clinix.modules.user.infrastructure.web;


import com.clinix.common.constant.ApiRoutes;
import com.clinix.common.valueobject.Uuid;
import com.clinix.modules.user.application.UserUseCases;
import com.clinix.modules.user.infrastructure.persistence.projection.DoctorInfo;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo;
import com.clinix.modules.user.infrastructure.web.dto.UserDTO;
import com.clinix.modules.user.infrastructure.web.mapper.UserWebMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.logging.Logger;


@Path(ApiRoutes.Users.ROOT)
public class UserResource {

    private static final Logger LOG = Logger.getLogger(UserResource.class);

    private final UserUseCases userUseCases;
    private final UserWebMapper userWebMapper;

    public UserResource(UserUseCases userUseCases, UserWebMapper userWebMapper) {
        this.userUseCases = userUseCases;
        this.userWebMapper = userWebMapper;
    }



    @Operation (
            summary = "Récupérer un utilisateur par son ID",
            description = "Cette opération permet de récupérer les détails d'un utilisateur en utilisant son ID unique."
    )
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Utilisateur trouvé avec succès.",
                    content = @Content(schema = @Schema(implementation = UserDTO.class))),
            @APIResponse(responseCode = "404", description = "Utilisateur non trouvé.")
    })
    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") String id) {
        LOG.infof("Recherche de l'utilisateur avec l'id : %s", id);

        Uuid uuid = new Uuid(id);
        UserInfo model = userUseCases.getUserById(uuid);
//        UserDTO user = userWebMapper.toDto(model);

        LOG.infof("Utilisateur trouvé : %s", model);
        return Response.ok(model).build();
    }


    /*@POST
    public Response createSecretary(CreateSecretaryRequest request) {
        LOG.infof("Requête pour la création d'une secrétaire : %s", request);

        CreateSecretaryCommand command = userWebMapper.toCommand(request);
        UserSummaryReadModel model = userUseCases.createSecretary(command);
        UserDTO user = userWebMapper.toDto(model);

        LOG.infof("Secrétaire créée avec succès : %s", user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }*/
}
