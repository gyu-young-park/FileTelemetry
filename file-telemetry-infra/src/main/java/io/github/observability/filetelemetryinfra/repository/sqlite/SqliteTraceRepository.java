package io.github.observability.filetelemetryinfra.repository.sqlite;

import io.github.observability.filetelemetrycore.domain.trace.Trace;
import io.github.observability.filetelemetrycore.repository.TraceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Repository
@RequiredArgsConstructor
@Profile("standalone")
public class SqliteTraceRepository implements TraceRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(Trace trace) {
        if (trace.getCreatedAt() == null) {
            trace.setCreatedAt(LocalDateTime.now());
        }

        jdbcTemplate.update("""
            INSERT INTO traces (user_name, 
                                trace_key, 
                                start_time, 
                                status, 
                                end_time, 
                                created_at,
                                updated_at)
            VALUES (?, ?, ?, ? , ?, ?, ?)
        """, trace.getUserName(),
                trace.getKey(),
                trace.getStartTime().atZone(ZoneOffset.systemDefault()).toInstant().toEpochMilli(),
                trace.getStatus(),
                null,
                trace.getCreatedAt().atZone(ZoneOffset.systemDefault()).toInstant().toEpochMilli(),
                LocalDateTime.now().atZone(ZoneOffset.systemDefault()).toInstant().toEpochMilli());
    }
}
