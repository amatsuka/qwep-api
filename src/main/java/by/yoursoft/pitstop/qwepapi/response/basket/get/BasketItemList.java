package by.yoursoft.pitstop.qwepapi.response.basket.get;

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

    private List<BasketItem> basketItem = new LinkedList<>();
    private List<BasketForm> basketForm = new LinkedList<>();

    private boolean status;

}
