package by.yoursoft.pitstop.qwepapi.request.basket.add;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class BasketAddRequestBody {
    private int itemId;
    private int quantity;
    private String comment;
    private int type;
}
