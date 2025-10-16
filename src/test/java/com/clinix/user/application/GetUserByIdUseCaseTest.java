package com.clinix.user.application;


import com.clinix.common.exception.ErrorCode;
import com.clinix.common.exception.NotFoundException;
import com.clinix.common.valueobject.Uuid;
import com.clinix.modules.user.application.query.usecase.GetUserByIdUseCase;
import com.clinix.modules.user.domain.UserRepository;
import com.clinix.modules.user.application.query.readmodel.UserSummaryReadModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
class GetUserByIdUseCaseTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    GetUserByIdUseCase getUserByIdUseCase;


    @Test
    void testUserFound() {

        UUID uuid = UUID.randomUUID();
        Uuid id = new Uuid(uuid.toString());

        UserSummaryReadModel proj = new UserSummaryReadModel(uuid, "test@email.com", "First", "Last");

        Mockito.when(userRepository.findSummaryById(uuid))
                .thenReturn(Optional.of(proj));

        UserSummaryReadModel result = getUserByIdUseCase.execute(id);

        Mockito.verify(userRepository).findSummaryById(uuid);

        assertThat(result.id()).isEqualTo(proj.id());
        assertThat(result.email()).isEqualTo(proj.email());
        assertThat(result.firstname()).isEqualTo(proj.firstname());
        assertThat(result.lastname()).isEqualTo(proj.lastname());
    }

    @Test
    void testUserNotFound() {
        UUID uuid = UUID.randomUUID();
        Uuid id = new Uuid(uuid.toString());

        Mockito.when(userRepository.findSummaryById(uuid))
                .thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> getUserByIdUseCase.execute(id)
        );

        Mockito.verify(userRepository).findSummaryById(uuid);
        assertThat(exception.getMessage()).isEqualTo(ErrorCode.USER_NOT_FOUND.getMessage());
    }
}
