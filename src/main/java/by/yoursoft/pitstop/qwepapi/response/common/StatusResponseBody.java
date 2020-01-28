package by.yoursoft.pitstop.qwepapi.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusResponseBody {
    private boolean status;
}
