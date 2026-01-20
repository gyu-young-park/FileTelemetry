package io.github.observability.filetelemetryapi;

import io.github.observability.filetelemetrycore.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileTelemetryApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileTelemetryApiApplication.class, args);
    }
}
