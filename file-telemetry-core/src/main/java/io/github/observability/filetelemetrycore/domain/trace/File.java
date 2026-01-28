package io.github.observability.filetelemetrycore.domain.trace;

import io.github.observability.filetelemetrycore.domain.platform.User;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class File {
    private UUID traceId;
    private UUID userId;
    private String userName;
    private String key;
    private String name;
    private int fileSize;
    private String status;
    private String extension;
    private LocalDateTime createdAt;
}
