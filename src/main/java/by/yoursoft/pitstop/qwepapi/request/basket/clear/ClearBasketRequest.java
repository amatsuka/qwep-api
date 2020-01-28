package by.yoursoft.pitstop.qwepapi.request.basket.clear;

import by.yoursoft.pitstop.qwepapi.request.BaseRequest;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ClearBasketRequest extends BaseRequest<ClearBasketRequestBody> {
}
