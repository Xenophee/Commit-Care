package com.clinix.modules.user.infrastructure.persistence.mapper;

import org.mapstruct.Mapper;
import com.clinix.modules.user.application.query.readmodel.UserSummaryReadModel;
import jakarta.persistence.Tuple;

import java.util.UUID;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    default UserSummaryReadModel fromTuple(Tuple tuple) {
        return new UserSummaryReadModel(
                tuple.get("id", UUID.class),
                tuple.get("email", String.class),
                tuple.get("firstname", String.class),
                tuple.get("lastname", String.class)
        );
    }
}
