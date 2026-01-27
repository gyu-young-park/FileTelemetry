package io.github.observability.filetelemetrycore;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Summary {
    private String name;
    private String timeWindow;
    private int traceCount;
    private int fileCount;
    private int dataCount;
    private int dropFilesCount;
    private LocalDateTime createdAt;
}
