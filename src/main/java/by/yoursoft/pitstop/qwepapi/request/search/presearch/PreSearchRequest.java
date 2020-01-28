package by.yoursoft.pitstop.qwepapi.request.search.presearch;

import by.yoursoft.pitstop.qwepapi.request.BaseRequest;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class PreSearchRequest extends BaseRequest<PreSearchRequestBody> {

}