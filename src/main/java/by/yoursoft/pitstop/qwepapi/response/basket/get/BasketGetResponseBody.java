package by.yoursoft.pitstop.qwepapi.response.basket.get;

import lombok.Data;

import java.util.List;

@Data
public class BasketGetResponseBody {
    private List<BasketItemList> baskets;
}
