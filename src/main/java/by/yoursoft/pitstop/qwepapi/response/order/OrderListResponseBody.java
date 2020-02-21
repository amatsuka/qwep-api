package by.yoursoft.pitstop.qwepapi.response.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderListResponseBody {
    private List<Order> orders = new LinkedList<>();
}
