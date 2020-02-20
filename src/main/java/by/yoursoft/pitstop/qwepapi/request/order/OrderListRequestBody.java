package by.yoursoft.pitstop.qwepapi.request.order;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class OrderListRequestBody {
    private Long Id;
    private int limit;
}
