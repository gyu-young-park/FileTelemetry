package io.github.observability.filetelemetrycore.domain.platform;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String name;
    private String key;
    private String clientId;
    private String password;
    private boolean canExport;
    private UserRole userRole;
    private UserStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLoginAt;

    public static User register(String name, String key, String password) {
        User user = new User();
        user.setName(name);
        user.setKey(key);
        user.setPassword(password);
        user.setUserRole(UserRole.APP);
        user.setStatus(UserStatus.ACTIVE);
        return user;
    }
}
