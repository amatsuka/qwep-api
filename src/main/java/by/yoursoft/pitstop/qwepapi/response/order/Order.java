package by.yoursoft.pitstop.qwepapi.response.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private String number;
    private LocalDateTime datetime;
    private String status;
    private BigDecimal total;
    private String warehouse;
    private String comment;
    private List<Content> content;
}
