package by.yoursoft.pitstop.qwepapi.response.basket.order;

import by.yoursoft.pitstop.qwepapi.response.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("Response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketOrderResponse extends AbstractResponse<BasketOrderResponseBody> {
}
