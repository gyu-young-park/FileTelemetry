package io.github.observability.filetelemetrycore.domain.storage;

import io.github.observability.filetelemetrycore.domain.platform.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class StoredFile {
    private UUID storage;
    private UUID user;
    private String name;
    private boolean compressed;
    private int size;
    private LocalDateTime storedAt;
    private LocalDateTime updatedAt;
}
