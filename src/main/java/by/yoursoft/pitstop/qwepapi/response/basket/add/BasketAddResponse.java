package by.yoursoft.pitstop.qwepapi.response.basket.add;

import by.yoursoft.pitstop.qwepapi.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketAddResponse extends BaseResponse<BasketAddResponseBody> {
}
