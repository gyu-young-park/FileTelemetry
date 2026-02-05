package io.github.observability.filetelemetryinfra.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    private long id;
    private String key;
    private String role;
    private String name;
    private String secretHash;
    private boolean export;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLoginAt;

}
