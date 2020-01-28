package by.yoursoft.pitstop.qwepapi.request.basket.change;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class ChangeBasketItemRequestBody {
    private Long accountId;
    private Long basketId;
    private Long basketItemId;
    private Long quantity;
}
