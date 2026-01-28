package io.github.observability.filetelemetrycore.domain.platform;

import io.github.observability.filetelemetrycore.domain.trace.TelemetryChannelType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Subscription {
    private UUID userId;
    private TelemetryChannelType channelType;
    private String channelKey;
    private String status;
    private LocalDateTime createdAt;
}
