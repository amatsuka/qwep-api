package by.yoursoft.pitstop.qwepapi.request.basket.add;

import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAdd;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class BasketAddRequestBody {
    private List<BasketAdd> baskets;
}
