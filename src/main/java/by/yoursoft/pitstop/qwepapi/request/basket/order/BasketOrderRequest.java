package by.yoursoft.pitstop.qwepapi.request.basket.order;

import by.yoursoft.pitstop.qwepapi.request.BaseRequest;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BasketOrderRequest extends BaseRequest<BasketOrderRequestBody> {
}
