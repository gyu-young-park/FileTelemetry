package io.github.observability.filetelemetrycore;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Subscription {
    private User user;
    private TelemetryChannelType channelType;
    private String channelKey;
    private String status;
    private LocalDateTime createdAt;
}
