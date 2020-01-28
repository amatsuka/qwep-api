package by.yoursoft.pitstop.qwepapi.request.basket.delete;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class DeleteFromBasketRequestBody {
    private Long accountId;
    private Long basketId;
    private Long basketItemId;
}
