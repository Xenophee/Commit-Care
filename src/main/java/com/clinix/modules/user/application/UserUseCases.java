package com.clinix.modules.user.application;


import com.clinix.common.valueobject.Uuid;
import com.clinix.modules.user.application.command.usecase.CreateSecretaryUseCase;
import com.clinix.modules.user.application.command.writemodel.CreateSecretaryCommand;
import com.clinix.modules.user.application.query.readmodel.UserSummaryReadModel;
import com.clinix.modules.user.application.query.usecase.GetUserByIdUseCase;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo2;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserUseCases {

    private final GetUserByIdUseCase getUserByIdUseCase;
    private final CreateSecretaryUseCase createSecretaryUseCase;


    public UserUseCases(GetUserByIdUseCase getUserByIdUseCase, CreateSecretaryUseCase createSecretaryUseCase) {
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.createSecretaryUseCase = createSecretaryUseCase;
    }


    public UserInfo2 getUserById(Uuid uuid) {
        return getUserByIdUseCase.execute(uuid);
    }

    public void createSecretary(CreateSecretaryCommand command) {
//        createSecretaryUseCase.execute(command);
    }
}
