package by.yoursoft.pitstop.qwepapi.response.basket.list;

import by.yoursoft.pitstop.qwepapi.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("Response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketListResponse extends BaseResponse<BasketListResponseBody> {

}
