package io.github.observability.filetelemetryapi.data.mapper;

import io.github.observability.filetelemetryapi.data.dto.user.CreateAppUserRequest;
import io.github.observability.filetelemetryapi.data.dto.user.CreateAppUserResponse;
import io.github.observability.filetelemetryapi.data.time.LocalDateTimeConvertor;
import io.github.observability.filetelemetrycore.domain.platform.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User to(CreateAppUserRequest createAppUserRequest) {
        return User.register(createAppUserRequest.getName(),
                            createAppUserRequest.getKey(),
                            createAppUserRequest.getSecret());
    }

    public CreateAppUserResponse to(User user) {
        CreateAppUserResponse createAppUserResponse = new CreateAppUserResponse();
        createAppUserResponse.setName(user.getName());
        createAppUserResponse.setKey(user.getKey());
        createAppUserResponse.setRole(user.getUserRole().name());
        createAppUserResponse.setStatus(user.getStatus().name());
        createAppUserResponse.setCreatedAt(LocalDateTimeConvertor.toPatternString(user.getCreatedAt()));
        return createAppUserResponse;
    }
}
