package by.yoursoft.pitstop.qwepapi.request.basket.order;

import by.yoursoft.pitstop.qwepapi.response.basket.list.BasketFormFields;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.LinkedList;
import java.util.List;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class BasketOrderRequestBody {
    private Long accountId;
    private Long formId;
    private List<BasketFormFields> fields = new LinkedList<>();
}
