package by.yoursoft.pitstop.qwepapi.response.basket.add;

import lombok.Data;

@Data
public class BasketItem {
    private Long itemId;
    private String purchaseId;
    private boolean status;
    private int type;
}
