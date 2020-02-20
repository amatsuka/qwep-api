package by.yoursoft.pitstop.qwepapi.response.order;

import by.yoursoft.pitstop.qwepapi.response.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("Response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderListResponse extends AbstractResponse<OrderListResponseBody> {
}
