package by.yoursoft.pitstop.qwepapi.response.basket.add;

import by.yoursoft.pitstop.qwepapi.response.common.AccountItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketAddResponseBody {
    private int itemId;
    private boolean status;
    private String purchaseId;
    private int type;
}
