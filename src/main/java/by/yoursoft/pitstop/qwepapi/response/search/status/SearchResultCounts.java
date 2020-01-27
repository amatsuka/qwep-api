package by.yoursoft.pitstop.qwepapi.response.search.status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultCounts {
    private Long clarifications;
    private Long items;
    private Long errors;
}