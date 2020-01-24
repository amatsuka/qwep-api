package by.yoursoft.pitstop.qwepapi.response;

import lombok.Data;

@Data
public class Warning {
    private Long code;
    private String message;
    private String details;
}
