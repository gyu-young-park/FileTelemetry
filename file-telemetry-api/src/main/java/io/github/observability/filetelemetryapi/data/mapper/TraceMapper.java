package io.github.observability.filetelemetryapi.data.mapper;

import io.github.observability.filetelemetryapi.data.dto.trace.CreateTraceRequest;
import io.github.observability.filetelemetryapi.data.dto.trace.CreateTraceResponse;
import io.github.observability.filetelemetryapi.data.time.LocalDateTimeConvertor;
import io.github.observability.filetelemetrycore.domain.trace.Trace;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
public class TraceMapper {
    public Trace to(CreateTraceRequest createTraceRequest) {
        LocalDateTime startTime = Instant.ofEpochMilli(createTraceRequest.getStartTime()).atZone(ZoneOffset.systemDefault()).toLocalDateTime();
        return Trace.start(createTraceRequest.getUserName(), createTraceRequest.getTraceKey(), startTime);
    }

    public CreateTraceResponse from(Trace trace) {
        CreateTraceResponse createTraceResponse = new CreateTraceResponse();
        createTraceResponse.setKey(trace.getKey());
        createTraceResponse.setUserName(trace.getUserName());
        createTraceResponse.setStartTIme(LocalDateTimeConvertor.toPatternString(trace.getCreatedAt()));
        return createTraceResponse;
    }
}
