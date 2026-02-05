package io.github.observability.filetelemetryapi.controller;

import io.github.observability.filetelemetryapi.data.dto.trace.CreateTraceRequest;
import io.github.observability.filetelemetryapi.data.dto.trace.CreateTraceResponse;
import io.github.observability.filetelemetryapi.data.mapper.TraceMapper;
import io.github.observability.filetelemetryapi.service.TraceService;
import io.github.observability.filetelemetrycore.domain.trace.Trace;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/telemetry/trace")
@RequiredArgsConstructor
public class TraceController {
    private final TraceMapper traceMapper;
    private final TraceService traceService;

    @PostMapping("")
    public ResponseEntity<CreateTraceResponse> createTrace(@RequestBody CreateTraceRequest createTraceRequest) {
        Trace trace = traceMapper.to(createTraceRequest);
        traceService.saveTrace(trace);
        return ResponseEntity.status(HttpStatus.CREATED).body(traceMapper.from(trace));
    }
}
