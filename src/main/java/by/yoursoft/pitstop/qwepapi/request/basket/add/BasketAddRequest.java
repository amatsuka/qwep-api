package by.yoursoft.pitstop.qwepapi.request.basket.add;

import by.yoursoft.pitstop.qwepapi.request.BaseRequest;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BasketAddRequest extends BaseRequest<BasketAddRequestBody> {
}
