package by.yoursoft.pitstop.qwepapi.response.basket.list;

import lombok.Data;

import java.util.List;

@Data
public class BasketListResponseBody {
    private List<BasketItemList> baskets;
}
