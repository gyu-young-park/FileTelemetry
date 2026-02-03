package io.github.observability.filetelemetrycore.domain.trace;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class Trace {
    private String userName;
    private String key;
    private String status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Trace() {}

    public static Trace start(String userName, String key, LocalDateTime startTime) {
        Trace trace = new Trace();
        trace.userName = userName;
        trace.key = key;
        trace.startTime = startTime;
        trace.status = "IN_PROGRESS";
        return trace;
    }

    @Setter
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
