package by.yoursoft.pitstop.qwepapi.request.basket.list;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonRootName("Request")
@Accessors(chain = true)
public class BasketListRequestBody {
    private Long accountId;
}
