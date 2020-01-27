package by.yoursoft.pitstop.qwepapi.request.search.status;

import by.yoursoft.pitstop.qwepapi.request.BaseRequest;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class SearchStatusRequest extends BaseRequest<SearchStatusRequestBody> {

}