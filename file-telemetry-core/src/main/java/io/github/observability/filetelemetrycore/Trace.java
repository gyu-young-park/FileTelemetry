package io.github.observability.filetelemetrycore;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Trace {
    private User user;
    private String key;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime createdAt;
}
