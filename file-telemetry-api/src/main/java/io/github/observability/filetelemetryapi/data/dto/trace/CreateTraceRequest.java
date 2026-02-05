package io.github.observability.filetelemetryapi.data.dto.trace;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

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
