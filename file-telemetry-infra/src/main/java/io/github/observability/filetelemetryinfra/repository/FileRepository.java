package io.github.observability.filetelemetryinfra.repository;

import io.github.observability.filetelemetryinfra.entity.FileEntity;

public interface FileRepository {
    void save(FileEntity fileEntity);
}
