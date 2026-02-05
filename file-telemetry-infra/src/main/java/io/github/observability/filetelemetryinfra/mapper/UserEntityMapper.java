package io.github.observability.filetelemetryinfra.mapper;

import io.github.observability.filetelemetrycore.domain.platform.User;
import io.github.observability.filetelemetrycore.domain.platform.UserRole;
import io.github.observability.filetelemetrycore.domain.platform.UserStatus;
import io.github.observability.filetelemetryinfra.entity.UserEntity;

public class UserEntityMapper {
    public static User to(UserEntity userEntity) {
        User user = new User();
        user.setKey(userEntity.getKey());
        user.setName(userEntity.getName());
        user.setUserRole(UserRole.valueOf(userEntity.getRole()));
        user.setStatus(UserStatus.valueOf(userEntity.getStatus()));
        user.setCreatedAt(userEntity.getCreatedAt());
        user.setUpdatedAt(userEntity.getUpdatedAt());
        return user;
    }
}
