package io.github.observability.filetelemetryinfra.repository.file;

import io.github.observability.filetelemetryinfra.entity.FileEntity;

public interface FileRepository {
    void save(FileEntity fileEntity);
}
