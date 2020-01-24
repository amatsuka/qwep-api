package by.yoursoft.pitstop.qwepapi.response.token;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenResponseBody {
    private String token;
    private String type;
}
