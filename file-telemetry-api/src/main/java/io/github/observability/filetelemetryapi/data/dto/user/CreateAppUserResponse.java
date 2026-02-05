package io.github.observability.filetelemetryapi.data.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateAppUserResponse {
    private String name;
    private String key;
    private String role;
    private String status;
    private String createdAt;
}
