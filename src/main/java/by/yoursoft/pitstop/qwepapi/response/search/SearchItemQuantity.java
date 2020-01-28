package by.yoursoft.pitstop.qwepapi.response.search;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SearchItemQuantity {
    private String sign;
    private Long value;
    private String unit;
    private Long multiplicity;
    private String formatted;
}