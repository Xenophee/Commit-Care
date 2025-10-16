package com.clinix.modules.user.infrastructure.web.mapper;

import com.clinix.modules.user.application.command.writemodel.CreateSecretaryCommand;
import com.clinix.modules.user.application.query.readmodel.UserSummaryReadModel;
import com.clinix.modules.user.infrastructure.web.dto.CreateSecretaryRequest;
import com.clinix.modules.user.infrastructure.web.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserWebMapper {

    UserDTO toDto(UserSummaryReadModel model);

    CreateSecretaryCommand toCommand(CreateSecretaryRequest request);
}
