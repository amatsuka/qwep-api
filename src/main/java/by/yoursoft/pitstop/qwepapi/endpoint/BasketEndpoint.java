package by.yoursoft.pitstop.qwepapi.endpoint;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.basket.add.BasketAddRequest;
import by.yoursoft.pitstop.qwepapi.request.basket.change.ChangeBasketItemRequest;
import by.yoursoft.pitstop.qwepapi.request.basket.clear.ClearBasketRequest;
import by.yoursoft.pitstop.qwepapi.request.basket.delete.DeleteFromBasketRequest;
import by.yoursoft.pitstop.qwepapi.request.basket.list.BasketListRequest;
import by.yoursoft.pitstop.qwepapi.response.basket.add.BasketAddResponse;
import by.yoursoft.pitstop.qwepapi.response.basket.list.BasketListResponse;
import by.yoursoft.pitstop.qwepapi.response.common.StatusResponse;
import by.yoursoft.pitstop.qwepapi.utils.HttpUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.Map;

public class BasketEndpoint extends AbstractEndpoint {
    public BasketEndpoint (QwepApiFactory factory) {super(factory); }

    private interface BasketService{
        @POST("/cart/add")
        Call<BasketAddResponse> addBasket(@HeaderMap Map<String, String> headers, @Body BasketAddRequest body);

        @POST("/basket")
        Call<BasketListResponse> getBasket(@HeaderMap Map<String, String> headers, @Body BasketListRequest body);

        @POST("/basket/clear")
        Call<StatusResponse> clearBasket(@HeaderMap Map<String, String> headers, @Body ClearBasketRequest body);

        @POST("/basket/deleteItem")
        Call<BasketListResponse> deleteFromBasket(@HeaderMap Map<String, String> headers, @Body DeleteFromBasketRequest body);

        @POST("/basket/changeItem")
        Call<BasketListResponse> changeItem(@HeaderMap Map<String, String> headers, @Body ChangeBasketItemRequest body);
    }

    public Response<BasketAddResponse> addBasket(BasketAddRequest request) throws IOException {
        BasketService service = getFactory().getHttpClient().create(BasketService.class);

        return service.addBasket(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

    public Response<BasketListResponse> getBasket(BasketListRequest request) throws IOException{
        BasketService service = getFactory().getHttpClient().create(BasketService.class);

        return service.getBasket(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

    public Response<StatusResponse> clearBasket(ClearBasketRequest request) throws IOException {
        BasketService service = getFactory().getHttpClient().create(BasketService.class);

        return service.clearBasket(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

    public Response<BasketListResponse> deleteFromBasket(DeleteFromBasketRequest request) throws IOException {
        BasketService service = getFactory().getHttpClient().create(BasketService.class);

        return service.deleteFromBasket(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

    public Response<BasketListResponse> changeBasketItem(ChangeBasketItemRequest request) throws IOException {
        BasketService service = getFactory().getHttpClient().create(BasketService.class);

        return service.changeItem(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }
}
