package by.yoursoft.pitstop.qwepapi.response;

import lombok.Data;

@Data
public class Error {
    private Long code;
    private String message;
    private String details;
}
