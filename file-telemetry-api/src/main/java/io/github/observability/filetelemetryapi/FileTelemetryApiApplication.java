package io.github.observability.filetelemetryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "io.github.observability.filetelemetryapi",
                "io.github.observability.filetelemetryinfra"}
)
    public class FileTelemetryApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileTelemetryApiApplication.class, args);
    }
}
