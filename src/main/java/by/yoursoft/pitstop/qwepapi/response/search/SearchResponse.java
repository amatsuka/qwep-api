package by.yoursoft.pitstop.qwepapi.response.search;

import by.yoursoft.pitstop.qwepapi.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResponse extends BaseResponse<SearchResponseBody> {
}