package io.github.observability.filetelemetryapi.service;

import io.github.observability.filetelemetrycore.domain.trace.Trace;
import io.github.observability.filetelemetrycore.repository.TraceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TraceService {
    private final TraceRepository traceRepository;

    public void saveTrace(Trace trace) {
        traceRepository.save(trace);
    }
}
