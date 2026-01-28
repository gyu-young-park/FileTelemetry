package io.github.observability.filetelemetrycore.domain.trace;

import io.github.observability.filetelemetrycore.domain.platform.User;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class DerivedData {
    private UUID traceId;
    private UUID userId;
    private String name;
    private String dataType;
    private String status;
    private LocalDateTime createdAt;
}
