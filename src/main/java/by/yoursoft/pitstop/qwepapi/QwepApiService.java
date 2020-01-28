package by.yoursoft.pitstop.qwepapi;

import by.yoursoft.pitstop.qwepapi.exception.QwepNetworkException;
import by.yoursoft.pitstop.qwepapi.exception.QwepTokenNotValidException;
import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAdd;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequest;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequestBody;
import by.yoursoft.pitstop.qwepapi.request.account.delete.AccountDeleteRequest;
import by.yoursoft.pitstop.qwepapi.request.account.delete.AccountDeleteRequestBody;
import by.yoursoft.pitstop.qwepapi.request.account.list.AccountListRequest;
import by.yoursoft.pitstop.qwepapi.request.account.list.AccountListRequestBody;
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
import by.yoursoft.pitstop.qwepapi.request.common.CommonFilter;
import by.yoursoft.pitstop.qwepapi.request.search.SearchRequest;
import by.yoursoft.pitstop.qwepapi.request.search.SearchSort;
import by.yoursoft.pitstop.qwepapi.request.search.clarification.OpenClarificationRequest;
import by.yoursoft.pitstop.qwepapi.request.search.clarification.OpenClarificationRequestBody;
import by.yoursoft.pitstop.qwepapi.request.search.presearch.PreSearchRequest;
import by.yoursoft.pitstop.qwepapi.request.search.presearch.PreSearchRequestBody;
import by.yoursoft.pitstop.qwepapi.request.search.status.SearchStatusRequest;
import by.yoursoft.pitstop.qwepapi.request.search.status.SearchStatusRequestBody;
import by.yoursoft.pitstop.qwepapi.request.search.updates.SearchUpdatesRequest;
import by.yoursoft.pitstop.qwepapi.request.search.updates.SearchUpdatesRequestBody;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListFilter;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListRequest;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListRequestBody;
import by.yoursoft.pitstop.qwepapi.response.AbstractResponse;
import by.yoursoft.pitstop.qwepapi.response.account.add.AccountAddResponse;
import by.yoursoft.pitstop.qwepapi.response.account.delete.AccountDeleteResponse;
import by.yoursoft.pitstop.qwepapi.response.account.get.AccountGetResponse;
import by.yoursoft.pitstop.qwepapi.response.basket.add.BasketAddResponse;
import by.yoursoft.pitstop.qwepapi.response.basket.add.BasketAddResponseBody;
import by.yoursoft.pitstop.qwepapi.response.basket.list.BasketItemList;
import by.yoursoft.pitstop.qwepapi.response.basket.list.BasketListResponse;
import by.yoursoft.pitstop.qwepapi.response.common.AccountItem;
import by.yoursoft.pitstop.qwepapi.response.common.StatusResponse;
import by.yoursoft.pitstop.qwepapi.response.search.SearchResponse;
import by.yoursoft.pitstop.qwepapi.response.search.SearchResponseBody;
import by.yoursoft.pitstop.qwepapi.response.search.presearch.PreSearchResponse;
import by.yoursoft.pitstop.qwepapi.response.search.presearch.ShortNumber;
import by.yoursoft.pitstop.qwepapi.response.search.status.SearchStatusResponse;
import by.yoursoft.pitstop.qwepapi.response.search.status.SearchStatusResponseBody;
import by.yoursoft.pitstop.qwepapi.response.vendor.VendorItem;
import by.yoursoft.pitstop.qwepapi.response.vendor.VendorListResponse;
import by.yoursoft.pitstop.qwepapi.utils.RequestUtils;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

@RequiredArgsConstructor
public class QwepApiService {

    private final QwepApiFactory qwepApiFactory;

    public List<VendorItem> getVendorList() {
        VendorListRequest request = new VendorListRequest();
        request.setRequestBody(new VendorListRequestBody().setFilters(new VendorListFilter()));

        VendorListResponse vendorListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeVendorEndpoint()::getVendorList, request));

        return vendorListResponse.getEntity().getVendors();
    }

    public List<AccountItem> addAccount(String vid, String bid, String login, String password, String parameters) {
        AccountAddRequest request = new AccountAddRequest();
        request.setRequestBody(new AccountAddRequestBody()
                .setAccounts(asList(new AccountAdd()
                        .setLogin(login)
                        .setVid(vid)
                        .setBid(bid)
                        .setPassword(password)
                        .setParameters(parameters))));

        AccountAddResponse vendorListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeAccountEndpoint()::addAccount, request));

        return vendorListResponse.getEntity().getAccounts();
    }

    public SearchResponseBody search(SearchRequestBuilder requestBuilder) {
        SearchRequest request = new SearchRequest();
        request.setRequestBody(requestBuilder.build());

        SearchResponse searchResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeSearchEndpoint()::search, request));

        return searchResponse.getEntity();
    }

    public SearchResponseBody searchUpdates(String searchId, List<SearchSort> sorts) {
        SearchUpdatesRequest request = new SearchUpdatesRequest();
        request.setRequestBody(new SearchUpdatesRequestBody()
                .setSearchId(searchId)
                .setSorts(sorts));

        SearchResponse searchResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeSearchEndpoint()::searchUpdates, request));

        return searchResponse.getEntity();
    }

    public SearchResponseBody searchResults(String searchId, List<SearchSort> sorts) {
        SearchUpdatesRequest request = new SearchUpdatesRequest();
        request.setRequestBody(new SearchUpdatesRequestBody()
                .setSearchId(searchId)
                .setSorts(sorts));

        SearchResponse searchResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeSearchEndpoint()::searchResults, request));

        return searchResponse.getEntity();
    }

    public SearchStatusResponseBody searchStatus(String searchId) {
        SearchStatusRequest request = new SearchStatusRequest();
        request.setRequestBody(new SearchStatusRequestBody().setSearchId(searchId));

        SearchStatusResponse searchStatusResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeSearchEndpoint()::searchStatus, request));

        return searchStatusResponse.getEntity();
    }

    public List<ShortNumber> preSearch(String article, List<CommonFilter<String>> accounts, List<CommonFilter<String>> vendors) {
        PreSearchRequest request = new PreSearchRequest();
        request.setRequestBody(new PreSearchRequestBody().setArticle(article).setAccounts(accounts).setVendors(vendors));

        PreSearchResponse preSearchResponse  = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeSearchEndpoint()::preSearch, request));

        return preSearchResponse.getEntity().getShortNumbers();
    }

    public SearchResponseBody openClarification(String clarificationId, List<SearchSort> sorts, int type) {
        OpenClarificationRequest request = new OpenClarificationRequest();
        request.setRequestBody(new OpenClarificationRequestBody().setClarificationId(clarificationId).setSorts(sorts).setType(type));

        SearchResponse searchResponse  = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeSearchEndpoint()::openClarification, request));

        return searchResponse.getEntity();
    }

    public SearchRequestBuilder searchRequestBuilder() {
        return new SearchRequestBuilder();
    }

    public List<AccountItem> getAccount(boolean promo, boolean enabled){
        AccountListRequest request = new AccountListRequest();
        request.setRequestBody(new AccountListRequestBody()
                .setPromo(promo)
                .setEnabled(enabled));

        AccountGetResponse accountListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeAccountEndpoint()::getAccount, request));

        return accountListResponse.getEntity().getAccounts();
    }

    public List<AccountItem> deleteAccount(Long id){
        AccountDeleteRequest request = new AccountDeleteRequest();
        request.setRequestBody(new AccountDeleteRequestBody()
            .setAccounts(asList(new CommonFilter<Long>()
                .setId(id))));
        AccountDeleteResponse accountListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeAccountEndpoint()::deleteAccount, request));

        return accountListResponse.getEntity().getAccounts();
    }

    public BasketAddResponseBody addBasket(int itemId, int quantity, String comment, int type) {
        BasketAddRequest request = new BasketAddRequest();
        request.setRequestBody(new BasketAddRequestBody()
                .setItemId(itemId)
                .setQuantity(quantity)
                .setComment(comment)
                .setType(type));

        BasketAddResponse basketAddResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeBasketEndpoint()::addBasket, request));

        return basketAddResponse.getEntity();
    }
    public List<BasketItemList> getBasket(Long accountId){
        BasketListRequest request = new BasketListRequest();
        request.setRequestBody(new BasketListRequestBody()
            .setAccountId(accountId));

        BasketListResponse basketListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeBasketEndpoint()::getBasket, request));

        return basketListResponse.getEntity().getBaskets();
    }
    public boolean clearBasket(Long accountId, Long basketId) {
        ClearBasketRequest request = new ClearBasketRequest();
        request.setRequestBody(new ClearBasketRequestBody()
                .setAccountId(accountId)
                .setBasketId(basketId));

        StatusResponse statusResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeBasketEndpoint()::clearBasket, request));

        return statusResponse.getEntity().isStatus();
    }

    public List<BasketItemList> deleteFromBasket(Long accountId, Long basketId, Long basketItemId) {
        DeleteFromBasketRequest request = new DeleteFromBasketRequest();
        request.setRequestBody(new DeleteFromBasketRequestBody()
                .setAccountId(accountId)
                .setBasketId(basketId)
                .setBasketItemId(basketItemId));

        BasketListResponse response = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeBasketEndpoint()::deleteFromBasket, request));

        return response.getEntity().getBaskets();
    }

    public List<BasketItemList> changeBasketItemQuantity(Long accountId, Long basketId, Long basketItemId, Long quantity) {
        ChangeBasketItemRequest request = new ChangeBasketItemRequest();
        request.setRequestBody(new ChangeBasketItemRequestBody()
                .setAccountId(accountId)
                .setBasketId(basketId)
                .setBasketItemId(basketItemId)
                .setQuantity(quantity));

        BasketListResponse response = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeBasketEndpoint()::changeBasketItem, request));

        return response.getEntity().getBaskets();
    }

    private <R, T extends AbstractResponse<R>> T executeWithRefreshTokenIfNeed(Supplier<T> fun) {
        try {
            return fun.get();

        } catch (QwepTokenNotValidException ex) {
            //Если токен просрочен очищаем его в хранилище и пытаемся выполнить запрос снова
            qwepApiFactory.getConfig().getTokenStorage().removeToken();
            try {
                return fun.get();
            } catch (QwepTokenNotValidException ex1) {
                //Перезапрос токена не помог - выбрасываем исключение
                throw new QwepNetworkException("qwep.connection.error", ex1);
            }
        }
    }
}
