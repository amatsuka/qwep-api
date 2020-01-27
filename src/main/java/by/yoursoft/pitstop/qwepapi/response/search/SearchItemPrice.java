package by.yoursoft.pitstop.qwepapi.response.search;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SearchItemPrice {
    private BigDecimal value;
    private String currency;
    private String formatted;
}