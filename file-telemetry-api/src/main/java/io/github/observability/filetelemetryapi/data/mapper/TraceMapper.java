package io.github.observability.filetelemetryapi.data.mapper;

import io.github.observability.filetelemetryapi.data.dto.CreateTraceRequest;
import io.github.observability.filetelemetryapi.data.dto.CreateTraceResponse;
import io.github.observability.filetelemetrycore.domain.trace.Trace;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
public class TraceMapper {
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public Trace to(CreateTraceRequest createTraceRequest) {
        LocalDateTime startTime = Instant.ofEpochMilli(createTraceRequest.getStartTime()).atZone(ZoneOffset.systemDefault()).toLocalDateTime();
        return Trace.start(createTraceRequest.getUserName(), createTraceRequest.getTraceKey(), startTime);
    }

    public CreateTraceResponse from(Trace trace) {
        CreateTraceResponse createTraceResponse = new CreateTraceResponse();
        createTraceResponse.setKey(trace.getKey());
        createTraceResponse.setUserName(trace.getUserName());
        createTraceResponse.setStartTIme(trace.getStartTime().format(dateTimeFormatter));
        return createTraceResponse;
    }
}
