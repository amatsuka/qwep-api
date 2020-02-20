package by.yoursoft.pitstop.qwepapi.response.search;

import by.yoursoft.pitstop.qwepapi.utils.json.JsonDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchItem {
    private Long itemId;
    private String fromClarification;
    private String brand;
    private boolean highlightBrand;
    private String article;
    private String originalArticle;
    private String title;
    private String photo;
    private String notes;
    private Long city;
    private String subway;
    private String warehouse;
    private String origWarehouse;
    private String delivery;

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private LocalDateTime deliveryStart;

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    private LocalDateTime deliveryEnd;

    private String status;
    private Long minQuantity;
    private SearchItemPrice price;
}