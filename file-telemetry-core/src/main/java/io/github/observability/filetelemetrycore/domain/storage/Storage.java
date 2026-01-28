package io.github.observability.filetelemetrycore.domain.storage;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Storage {
    private String name;
    private String type;
    private String path;
    private LocalDateTime createdAt;
}
