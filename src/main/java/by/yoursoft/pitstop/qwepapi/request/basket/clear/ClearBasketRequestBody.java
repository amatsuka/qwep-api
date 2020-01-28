package by.yoursoft.pitstop.qwepapi.request.basket.clear;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class ClearBasketRequestBody {
    private Long accountId;
    private Long basketId;
}
