package by.yoursoft.pitstop.qwepapi.endpoint;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.basket.add.BasketAddRequest;
import by.yoursoft.pitstop.qwepapi.request.basket.clear.ClearBasketRequest;
import by.yoursoft.pitstop.qwepapi.response.basket.add.BasketAddResponse;
import by.yoursoft.pitstop.qwepapi.response.common.StatusResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BasketEndpoint extends BaseEndpoint{
    public BasketEndpoint (QwepApiFactory factory) {super(factory); }

    public interface BasketService{
        @POST("/cart/add")
        Call<BasketAddResponse> addBasket(@HeaderMap Map<String, String> headers, @Body BasketAddRequest body);

        @POST("/basket/clear")
        Call<StatusResponse> clearBasket(@HeaderMap Map<String, String> headers, @Body ClearBasketRequest body);
    }

    public Response<BasketAddResponse> addBasket(BasketAddRequest request) throws IOException {
        BasketEndpoint.BasketService service = getFactory().getHttpClient().create(BasketEndpoint.BasketService.class);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + getToken());

        return service.addBasket(headers, request).execute();
    }

    public Response<StatusResponse> clearBasket(ClearBasketRequest request) throws IOException {
        BasketService service = getFactory().getHttpClient().create(BasketService.class);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + getToken());

        return service.clearBasket(headers, request).execute();
    }
}
