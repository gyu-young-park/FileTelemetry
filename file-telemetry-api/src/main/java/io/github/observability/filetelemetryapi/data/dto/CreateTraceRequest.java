package io.github.observability.filetelemetryapi.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateTraceRequest {
    @JsonProperty("name")
    private String userName;

    @JsonProperty("key")
    private String traceKey;

    @JsonProperty("start_time")
    private Long startTime;
}
