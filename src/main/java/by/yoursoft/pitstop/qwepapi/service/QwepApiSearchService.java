package by.yoursoft.pitstop.qwepapi.service;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
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
import by.yoursoft.pitstop.qwepapi.response.search.SearchResponse;
import by.yoursoft.pitstop.qwepapi.response.search.SearchResponseBody;
import by.yoursoft.pitstop.qwepapi.response.search.presearch.PreSearchResponse;
import by.yoursoft.pitstop.qwepapi.response.search.presearch.ShortNumber;
import by.yoursoft.pitstop.qwepapi.response.search.status.SearchStatusResponse;
import by.yoursoft.pitstop.qwepapi.response.search.status.SearchStatusResponseBody;
import by.yoursoft.pitstop.qwepapi.utils.RequestUtils;

import java.util.List;

public class QwepApiSearchService extends AbstractQwepApiService {

    public QwepApiSearchService(QwepApiFactory qwepApiFactory) {
        super(qwepApiFactory);
    }

    public SearchResponseBody search(SearchRequestBuilder requestBuilder) {
        SearchRequest request = new SearchRequest();
        request.setRequestBody(requestBuilder.build());

        SearchResponse searchResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeSearchEndpoint()::search, request));

        return searchResponse.getEntity();
    }

    public SearchResponseBody searchUpdates(String searchId, List<SearchSort> sorts) {
        SearchUpdatesRequest request = new SearchUpdatesRequest();
        request.setRequestBody(new SearchUpdatesRequestBody()
                .setSearchId(searchId)
                .setSorts(sorts));

        SearchResponse searchResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeSearchEndpoint()::searchUpdates, request));

        return searchResponse.getEntity();
    }

    public SearchResponseBody searchResults(String searchId, List<SearchSort> sorts) {
        SearchUpdatesRequest request = new SearchUpdatesRequest();
        request.setRequestBody(new SearchUpdatesRequestBody()
                .setSearchId(searchId)
                .setSorts(sorts));

        SearchResponse searchResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeSearchEndpoint()::searchResults, request));

        return searchResponse.getEntity();
    }

    public SearchStatusResponseBody searchStatus(String searchId) {
        SearchStatusRequest request = new SearchStatusRequest();
        request.setRequestBody(new SearchStatusRequestBody().setSearchId(searchId));

        SearchStatusResponse searchStatusResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeSearchEndpoint()::searchStatus, request));

        return searchStatusResponse.getEntity();
    }

    public List<ShortNumber> preSearch(String article, List<CommonFilter<String>> accounts, List<CommonFilter<String>> vendors) {
        PreSearchRequest request = new PreSearchRequest();
        request.setRequestBody(new PreSearchRequestBody().setArticle(article).setAccounts(accounts).setVendors(vendors));

        PreSearchResponse preSearchResponse  = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeSearchEndpoint()::preSearch, request));

        return preSearchResponse.getEntity().getShortNumbers();
    }

    public SearchResponseBody openClarification(String clarificationId, List<SearchSort> sorts, int type) {
        OpenClarificationRequest request = new OpenClarificationRequest();
        request.setRequestBody(new OpenClarificationRequestBody().setClarificationId(clarificationId).setSorts(sorts).setType(type));

        SearchResponse searchResponse  = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeSearchEndpoint()::openClarification, request));

        return searchResponse.getEntity();
    }

    public SearchRequestBuilder searchRequestBuilder() {
        return new SearchRequestBuilder();
    }
}
