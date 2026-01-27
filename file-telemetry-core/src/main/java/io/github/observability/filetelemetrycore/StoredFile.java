package io.github.observability.filetelemetrycore;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoredFile {
    private Storage storage;
    private User user;
    private String name;
    private boolean compressed;
    private int size;
    private LocalDateTime storedAt;
    private LocalDateTime updatedAt;
}
