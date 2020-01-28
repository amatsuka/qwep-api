package by.yoursoft.pitstop.qwepapi.response.basket.add;

import by.yoursoft.pitstop.qwepapi.response.common.AccountItem;
import lombok.Data;

import java.util.List;

@Data
public class BasketAddResponseBody {
    List<BasketItem> baskets;
}
