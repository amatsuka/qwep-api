package by.yoursoft.pitstop.qwepapi.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Error {
    private Long code;
    private String message;
    private String details;
    private String level;
}
