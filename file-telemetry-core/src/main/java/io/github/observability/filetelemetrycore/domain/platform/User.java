package io.github.observability.filetelemetrycore.domain.platform;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String name;
    private String key;
    private String clientId;
    private String password;
    private String userRole;
    private boolean export;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLoginAt;
}
