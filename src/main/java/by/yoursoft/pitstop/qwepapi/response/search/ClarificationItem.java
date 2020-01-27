package by.yoursoft.pitstop.qwepapi.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClarificationItem {
    private String clarificationId;
    private String brand;
    private String article;
    private String title;
    private String photo;
    private String notes;
}
