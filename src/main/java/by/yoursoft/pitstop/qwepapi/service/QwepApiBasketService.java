package by.yoursoft.pitstop.qwepapi.service;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.basket.add.BasketAddRequest;
import by.yoursoft.pitstop.qwepapi.request.basket.add.BasketAddRequestBody;
import by.yoursoft.pitstop.qwepapi.request.basket.change.ChangeBasketItemRequest;
import by.yoursoft.pitstop.qwepapi.request.basket.change.ChangeBasketItemRequestBody;
import by.yoursoft.pitstop.qwepapi.request.basket.clear.ClearBasketRequest;
import by.yoursoft.pitstop.qwepapi.request.basket.clear.ClearBasketRequestBody;
import by.yoursoft.pitstop.qwepapi.request.basket.delete.DeleteFromBasketRequest;
import by.yoursoft.pitstop.qwepapi.request.basket.delete.DeleteFromBasketRequestBody;
import by.yoursoft.pitstop.qwepapi.request.basket.list.BasketListRequest;
import by.yoursoft.pitstop.qwepapi.request.basket.list.BasketListRequestBody;
import by.yoursoft.pitstop.qwepapi.request.basket.order.BasketOrderRequest;
import by.yoursoft.pitstop.qwepapi.request.basket.order.BasketOrderRequestBody;
import by.yoursoft.pitstop.qwepapi.response.basket.add.BasketAddResponse;
import by.yoursoft.pitstop.qwepapi.response.basket.add.BasketAddResponseBody;
import by.yoursoft.pitstop.qwepapi.response.basket.list.BasketFormFields;
import by.yoursoft.pitstop.qwepapi.response.basket.list.BasketItemList;
import by.yoursoft.pitstop.qwepapi.response.basket.list.BasketListResponse;
import by.yoursoft.pitstop.qwepapi.response.basket.order.BasketOrderResponse;
import by.yoursoft.pitstop.qwepapi.response.common.StatusResponse;
import by.yoursoft.pitstop.qwepapi.utils.RequestUtils;

import java.util.List;

public class QwepApiBasketService extends AbstractQwepApiService {

    public QwepApiBasketService(QwepApiFactory qwepApiFactory) {
        super(qwepApiFactory);
    }

    public BasketAddResponseBody addBasket(int itemId, int quantity, String comment, int type) {
        BasketAddRequest request = new BasketAddRequest();
        request.setRequestBody(new BasketAddRequestBody()
                .setItemId(itemId)
                .setQuantity(quantity)
                .setComment(comment)
                .setType(type));

        BasketAddResponse basketAddResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeBasketEndpoint()::addBasket, request));

        return basketAddResponse.getEntity();
    }
    public List<BasketItemList> getBasket(Long accountId){
        BasketListRequest request = new BasketListRequest();
        request.setRequestBody(new BasketListRequestBody()
            .setAccountId(accountId));

        BasketListResponse basketListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeBasketEndpoint()::getBasket, request));

        return basketListResponse.getEntity().getBaskets();
    }
    public boolean clearBasket(Long accountId, Long basketId) {
        ClearBasketRequest request = new ClearBasketRequest();
        request.setRequestBody(new ClearBasketRequestBody()
                .setAccountId(accountId)
                .setBasketId(basketId));

        StatusResponse statusResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeBasketEndpoint()::clearBasket, request));

        return statusResponse.getEntity().isStatus();
    }

    public List<BasketItemList> deleteFromBasket(Long accountId, Long basketId, Long basketItemId) {
        DeleteFromBasketRequest request = new DeleteFromBasketRequest();
        request.setRequestBody(new DeleteFromBasketRequestBody()
                .setAccountId(accountId)
                .setBasketId(basketId)
                .setBasketItemId(basketItemId));

        BasketListResponse response = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeBasketEndpoint()::deleteFromBasket, request));

        return response.getEntity().getBaskets();
    }

    public List<BasketItemList> changeBasketItemQuantity(Long accountId, Long basketId, Long basketItemId, Long quantity) {
        ChangeBasketItemRequest request = new ChangeBasketItemRequest();
        request.setRequestBody(new ChangeBasketItemRequestBody()
                .setAccountId(accountId)
                .setBasketId(basketId)
                .setBasketItemId(basketItemId)
                .setQuantity(quantity));

        BasketListResponse response = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeBasketEndpoint()::changeBasketItem, request));

        return response.getEntity().getBaskets();
    }

    public List<BasketItemList> addOrder(Long accountId, Long formId, List<BasketFormFields> fieldValues) {
        BasketOrderRequest request = new BasketOrderRequest();
        request.setRequestBody(new BasketOrderRequestBody()
                .setAccountId(accountId)
                .setFormId(formId)
                .setFields(fieldValues));

        BasketOrderResponse response = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeBasketEndpoint()::addOrder, request));

        return response.getEntity().getBaskets();
    }
}
