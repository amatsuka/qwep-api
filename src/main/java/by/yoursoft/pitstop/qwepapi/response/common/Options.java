package by.yoursoft.pitstop.qwepapi.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Options {
    private int value;
    private String text;
    private String fields;
}
