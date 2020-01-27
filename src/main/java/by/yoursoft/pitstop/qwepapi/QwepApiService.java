package by.yoursoft.pitstop.qwepapi;

import by.yoursoft.pitstop.qwepapi.exception.QwepNetworkException;
import by.yoursoft.pitstop.qwepapi.exception.QwepTokenNotValidException;
import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.account.add.Account;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequest;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequestBody;
import by.yoursoft.pitstop.qwepapi.request.common.CommonFilter;
import by.yoursoft.pitstop.qwepapi.request.search.SearchRequest;
import by.yoursoft.pitstop.qwepapi.request.search.SearchRequestBody;
import by.yoursoft.pitstop.qwepapi.request.search.SearchSort;
import by.yoursoft.pitstop.qwepapi.request.search.presearch.PreSearchRequest;
import by.yoursoft.pitstop.qwepapi.request.search.status.SearchStatusRequest;
import by.yoursoft.pitstop.qwepapi.request.search.updates.SearchUpdatesRequest;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListFilter;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListRequest;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListRequestBody;
import by.yoursoft.pitstop.qwepapi.response.BaseResponse;
import by.yoursoft.pitstop.qwepapi.response.account.add.AccountAddResponse;
import by.yoursoft.pitstop.qwepapi.response.account.add.AccountItem;
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
                .setAccounts(asList(new Account()
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

        SearchResponse searchResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeSearchEndpoint()::searchUpdates, request));

        return searchResponse.getEntity();
    }

    public SearchResponseBody searchResults(String searchId, List<SearchSort> sorts) {
        SearchUpdatesRequest request = new SearchUpdatesRequest();

        SearchResponse searchResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeSearchEndpoint()::searchResults, request));

        return searchResponse.getEntity();
    }

    public SearchStatusResponseBody searchStatus(String searchId) {
        SearchStatusRequest request = new SearchStatusRequest();

        SearchStatusResponse searchStatusResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeSearchEndpoint()::searchStatus, request));

        return searchStatusResponse.getEntity();
    }


    public List<ShortNumber> preSearch(String article, List<CommonFilter> accounts, List<CommonFilter> vendors) {
        PreSearchRequest request = new PreSearchRequest();

        PreSearchResponse preSearchResponse  = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeSearchEndpoint()::preSearch, request));

        return preSearchResponse.getEntity().getShortNumbers();
    }

    public SearchRequestBuilder searchRequestBuilder() {
        return new SearchRequestBuilder();
    }

    private <R, T extends BaseResponse<R>> T executeWithRefreshTokenIfNeed(Supplier<T> fun) {
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
