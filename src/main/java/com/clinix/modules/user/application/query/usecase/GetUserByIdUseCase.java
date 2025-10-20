package com.clinix.modules.user.application.query.usecase;

import com.clinix.common.exception.ErrorCode;
import com.clinix.common.exception.NotFoundException;
import com.clinix.common.valueobject.Uuid;
import com.clinix.modules.user.application.query.readmodel.UserSummaryReadModel;
import com.clinix.modules.user.domain.UserRepository;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo;
import com.clinix.modules.user.infrastructure.persistence.projection.UserInfo2;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;


@ApplicationScoped
public class GetUserByIdUseCase {

    private static final Logger LOG = Logger.getLogger(GetUserByIdUseCase.class);

    private final UserRepository userRepository;

    public GetUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public UserInfo2 execute(Uuid uuid) {

        return userRepository.findSummaryById(uuid.value())
                .orElseThrow(() -> {
                    LOG.warnf("Utilisateur non trouvé avec l'id : %s", uuid);
                    return new NotFoundException(ErrorCode.USER_NOT_FOUND);
                });
    }
}
