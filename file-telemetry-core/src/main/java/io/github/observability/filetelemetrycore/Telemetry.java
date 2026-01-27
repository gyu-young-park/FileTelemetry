package io.github.observability.filetelemetrycore;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
public class Telemetry {
    private Trace trace;
    private User user;
    private Optional<DerivedData> opDerivedData;
    private Optional<File> opFile;
    private String message;
    private LocalDateTime createdAt;
}
