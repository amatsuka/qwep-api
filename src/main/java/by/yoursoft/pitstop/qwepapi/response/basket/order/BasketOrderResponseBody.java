package by.yoursoft.pitstop.qwepapi.response.basket.order;

import by.yoursoft.pitstop.qwepapi.response.basket.list.BasketItemList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketOrderResponseBody {
    private List<BasketItemList> baskets = new LinkedList<>();
    private boolean status;
}
