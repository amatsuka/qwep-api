package by.yoursoft.pitstop.qwepapi.response.search;

import by.yoursoft.pitstop.qwepapi.response.Error;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultItem {
    private Long accountId;
    private String vendorId;
    private String vendorTitle;
    private String branchId;
    private String branchTitle;
    private List<ClarificationItem> clarifications = new LinkedList<>();
    private List<Error> errors = new LinkedList<>();
    private List<SearchItem> items = new LinkedList<>();
}
