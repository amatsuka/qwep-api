package by.yoursoft.pitstop.qwepapi.request.basket.delete;

import by.yoursoft.pitstop.qwepapi.request.BaseRequest;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DeleteFromBasketRequest extends BaseRequest<DeleteFromBasketRequestBody> {
}
