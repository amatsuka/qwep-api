package by.yoursoft.pitstop.qwepapi.endpoint;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.order.OrderListRequest;
import by.yoursoft.pitstop.qwepapi.response.order.OrderListResponse;
import by.yoursoft.pitstop.qwepapi.utils.HttpUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.Map;

public class OrderEndpoint extends AbstractEndpoint {
    public OrderEndpoint(QwepApiFactory factory) {
        super(factory);
    }

    private interface OrderService {
        @POST("/orderlist")
        Call<OrderListResponse> getOrderList(@HeaderMap Map<String, String> headers, @Body OrderListRequest body);
    }

    public Response<OrderListResponse> getOrderList(OrderListRequest request) throws IOException {
        OrderEndpoint.OrderService service = getFactory().getHttpClient().create(OrderEndpoint.OrderService.class);

        return service.getOrderList(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }
}
