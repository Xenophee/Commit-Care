package com.clinix.modules.user.application.command.usecase;

import com.clinix.modules.user.application.command.writemodel.CreateSecretaryCommand;
import com.clinix.modules.user.application.query.readmodel.UserSummaryReadModel;
import com.clinix.modules.user.domain.UserRepository;
import com.clinix.modules.user.domain.model.User;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;

import java.util.UUID;

@ApplicationScoped
public class CreateSecretaryUseCase {

    private static final Logger LOG = Logger.getLogger(CreateSecretaryUseCase.class);

    private final UserRepository userRepository;

    public CreateSecretaryUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserSummaryReadModel execute(CreateSecretaryCommand command) {

        User user = new User(
                UUID.randomUUID(),
                command.email(),
                command.password(),
                command.firstname(),
                command.lastname()
        );
    }

}
