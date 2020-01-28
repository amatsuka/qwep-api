package by.yoursoft.pitstop.qwepapi.request.basket.list;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("Request")
public class BasketListRequestBody {
    private Long accountId;
}
