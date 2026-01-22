package io.github.observability.filetelemetryinfra.repository.file.sqlite;

import io.github.observability.filetelemetryinfra.entity.FileEntity;
import io.github.observability.filetelemetryinfra.repository.file.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
@RequiredArgsConstructor
@Profile("standalone")
public class SqliteFileRepository implements FileRepository {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void save(FileEntity entity) {
        LocalDate now = LocalDate.now();

        if (entity.getCreatedAt() == null) {
            entity.setCreatedAt(now);
        }
        entity.setUpdatedAt(now);

        jdbcTemplate.update(
                """
                INSERT INTO files (filename, created_at, updated_at)
                VALUES (?, ?, ?)
                """,
                entity.getFilename(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
