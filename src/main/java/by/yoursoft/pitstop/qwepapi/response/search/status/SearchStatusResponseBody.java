package by.yoursoft.pitstop.qwepapi.response.search.status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchStatusResponseBody {
   private String searchId;
   private boolean finished;

   private SearchResultCounts counts;

   private SearchBestOffer bestOffer;
}
