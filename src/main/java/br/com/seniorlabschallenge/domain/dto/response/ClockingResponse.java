package br.com.seniorlabschallenge.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClockingResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("system")
    private String system;
}
