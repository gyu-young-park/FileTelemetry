package io.github.observability.filetelemetryapi.controller;

import io.github.observability.filetelemetryinfra.entity.FileEntity;
import io.github.observability.filetelemetryinfra.repository.file.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file-controller")
public class FileController {
    private final FileRepository fileRepository;

    @GetMapping("/save")
    public String saveFileRepository() {
        FileEntity testEntity = new FileEntity();
        testEntity.setId(1L);
        testEntity.setFilename("hello world!");
        fileRepository.save(testEntity);
        return "hello";
    }
}
