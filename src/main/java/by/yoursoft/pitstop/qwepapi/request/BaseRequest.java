package by.yoursoft.pitstop.qwepapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class BaseRequest<T> {
    @JsonProperty("RequestData")
    private T requestBody;
}
