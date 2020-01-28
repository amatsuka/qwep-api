package by.yoursoft.pitstop.qwepapi.response.search.presearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PreSearchResponseBody {
   private List<ShortNumber> shortNumbers;
}
