package by.yoursoft.pitstop.qwepapi.response.basket.get;

import by.yoursoft.pitstop.qwepapi.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;


@JsonRootName("Response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketGetResponse extends BaseResponse<BasketGetResponseBody> {
    private List<BasketItemList> baskets;
}
