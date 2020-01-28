package by.yoursoft.pitstop.qwepapi.response.basket.list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketItemList {
    private int basketId;
    private int accountId;
    private String vendorId;
    private String vendorTitle;

    private List<BasketItem> basketItems = new LinkedList<>();
    private BasketForm basketForm;

    //private boolean status;

}
