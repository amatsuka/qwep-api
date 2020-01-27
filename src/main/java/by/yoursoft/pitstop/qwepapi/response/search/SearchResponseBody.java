package by.yoursoft.pitstop.qwepapi.response.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponseBody {
   private String searchId;
   private boolean finished;

   private List<SearchResultItem> results;
}
