package by.yoursoft.pitstop.qwepapi.service;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.order.OrderListRequest;
import by.yoursoft.pitstop.qwepapi.request.order.OrderListRequestBody;
import by.yoursoft.pitstop.qwepapi.response.order.OrderListResponse;
import by.yoursoft.pitstop.qwepapi.response.order.Order;
import by.yoursoft.pitstop.qwepapi.utils.RequestUtils;

import java.util.List;

public class QwepApiOrderService extends AbstractQwepApiService {
    public QwepApiOrderService(QwepApiFactory qwepApiFactory) {
        super(qwepApiFactory);
    }

    public List<Order> getOrderList(Long id, int limit){
        OrderListRequest request = new OrderListRequest();
        request.setRequestBody(new OrderListRequestBody()
                .setId(id)
                .setLimit(limit));

        OrderListResponse orderListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeOrderEndpoint()::getOrderList, request));

        return orderListResponse.getEntity().getOrders();

    }
}
