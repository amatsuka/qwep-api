package by.yoursoft.pitstop.qwepapi.response.search.status;

import by.yoursoft.pitstop.qwepapi.response.search.SearchItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchBestOffer {
    private Long accountId;
    private String vendorId;
    private String vendorName;
    private String branchId;
    private String branchName;
    private SearchItem item;
}
