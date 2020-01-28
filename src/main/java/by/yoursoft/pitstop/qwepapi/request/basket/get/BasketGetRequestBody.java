package by.yoursoft.pitstop.qwepapi.request.basket.get;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("Request")
public class BasketGetRequestBody {
    private Long accountId;
}
