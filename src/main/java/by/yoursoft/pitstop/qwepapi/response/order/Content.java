package by.yoursoft.pitstop.qwepapi.response.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {
    private String article;
    private String brand;
    private String partname;
    private String comment;
    private BigDecimal price;
    private int quantity;
    private String status;
    private String warehouse;
}
