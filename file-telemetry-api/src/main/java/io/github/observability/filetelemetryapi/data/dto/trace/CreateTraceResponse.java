package io.github.observability.filetelemetryapi.data.dto.trace;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateTraceResponse {
    private String key;
    private String userName;
    private String startTIme;
}
