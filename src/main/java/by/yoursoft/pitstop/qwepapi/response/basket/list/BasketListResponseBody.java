package by.yoursoft.pitstop.qwepapi.response.basket.list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketListResponseBody {
    private List<BasketItemList> baskets = new LinkedList<>();
    private boolean status;
}
