package by.yoursoft.pitstop.qwepapi.request.basket.change;

import by.yoursoft.pitstop.qwepapi.request.BaseRequest;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ChangeBasketItemRequest extends BaseRequest<ChangeBasketItemRequestBody> {
}
