package by.yoursoft.pitstop.qwepapi.response.basket.add;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketAddResponseBody {
    private int itemId;
    private boolean status;
    private String purchaseId;
    private int type;
}
