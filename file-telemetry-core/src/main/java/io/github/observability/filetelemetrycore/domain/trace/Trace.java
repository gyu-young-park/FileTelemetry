package io.github.observability.filetelemetrycore.domain.trace;

import io.github.observability.filetelemetrycore.domain.platform.User;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Trace {
    private UUID userId;
    private String userName;
    private String key;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createdAt;
}
