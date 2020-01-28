package by.yoursoft.pitstop.qwepapi.response.search;

import lombok.Data;

@Data
public class SearchItemQuantity {
    private String sign;
    private Long value;
    private String unit;
    private Long multiplicity;
    private String formatted;
}