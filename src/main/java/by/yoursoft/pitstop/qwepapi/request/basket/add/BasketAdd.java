package by.yoursoft.pitstop.qwepapi.request.basket.add;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BasketAdd {
    private Long itemId;
    private int quantity;
    private String comment;
    private int type;
}
