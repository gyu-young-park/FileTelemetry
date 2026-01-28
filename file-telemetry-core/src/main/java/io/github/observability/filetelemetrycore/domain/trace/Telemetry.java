package io.github.observability.filetelemetrycore.domain.trace;

import io.github.observability.filetelemetrycore.domain.platform.User;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Getter
public class Telemetry {
    private UUID traceId;
    private UUID userId;
    private String userName;
    private TelemetryParentType parentType;
    private UUID parentId;
    private String message;
    private LocalDateTime createdAt;
    private LocalDateTime arrivedAt;
}
