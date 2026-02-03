package io.github.observability.filetelemetrycore.repository;

import io.github.observability.filetelemetrycore.domain.trace.Trace;

public interface TraceRepository {
    void save(Trace trace);
}
