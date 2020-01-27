package by.yoursoft.pitstop.qwepapi.response.search.presearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShortNumber {
    private String id;
    private String article;
    private String brand;
    private String partname;
}
