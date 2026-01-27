package io.github.observability.filetelemetrycore;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DerivedData {
    private Trace trace;
    private User user;
    private String name;
    private String dataType;
    private String status;
    private LocalDateTime createdAt;
}
