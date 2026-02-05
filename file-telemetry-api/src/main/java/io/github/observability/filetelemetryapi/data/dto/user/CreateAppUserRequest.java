package io.github.observability.filetelemetryapi.data.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAppUserRequest {
    private String key;
    private String name;
    private String secret;
}
