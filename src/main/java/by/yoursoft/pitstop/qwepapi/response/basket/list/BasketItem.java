package by.yoursoft.pitstop.qwepapi.response.basket.list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.org.apache.xpath.internal.operations.String;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketItem {
    private int basketItemId;
    private int quantity;
    private int available;
    private String article;
    private String brand;
    private BigDecimal price;
    private BigDecimal priceTotal;
    private String title;
    private LocalDateTime delivery;
    private String warehouse;
    private List<BasketItemFields> basketItemFields = new LinkedList<>();
}
