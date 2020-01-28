package by.yoursoft.pitstop.qwepapi.request.search;

import by.yoursoft.pitstop.qwepapi.request.BaseRequest;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class SearchRequest extends BaseRequest<SearchRequestBody> {

}