package by.yoursoft.pitstop.qwepapi.endpoint;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.search.SearchRequest;
import by.yoursoft.pitstop.qwepapi.request.search.clarification.OpenClarificationRequest;
import by.yoursoft.pitstop.qwepapi.request.search.presearch.PreSearchRequest;
import by.yoursoft.pitstop.qwepapi.request.search.status.SearchStatusRequest;
import by.yoursoft.pitstop.qwepapi.request.search.updates.SearchUpdatesRequest;
import by.yoursoft.pitstop.qwepapi.response.search.SearchResponse;
import by.yoursoft.pitstop.qwepapi.response.search.presearch.PreSearchResponse;
import by.yoursoft.pitstop.qwepapi.response.search.status.SearchStatusResponse;
import by.yoursoft.pitstop.qwepapi.utils.HttpUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.Map;

public class SearchEndpoint extends AbstractEndpoint {
    public SearchEndpoint(QwepApiFactory factory) {
        super(factory);
    }

    private interface SearchService {
        @POST("/search")
        Call<SearchResponse> search(@HeaderMap Map<String, String> headers, @Body SearchRequest body);

        @POST("/search/updates")
        Call<SearchResponse> searchUpdates(@HeaderMap Map<String, String> headers, @Body SearchUpdatesRequest body);

        @POST("/search/results")
        Call<SearchResponse> searchResults(@HeaderMap Map<String, String> headers, @Body SearchUpdatesRequest body);

        @POST("/search/status")
        Call<SearchStatusResponse> searchStatus(@HeaderMap Map<String, String> headers, @Body SearchStatusRequest body);

        @POST("/preSearch")
        Call<PreSearchResponse> preSearch(@HeaderMap Map<String, String> headers, @Body PreSearchRequest body);

        @POST("/search")
        Call<SearchResponse> openClarification(@HeaderMap Map<String, String> headers, @Body OpenClarificationRequest body);
    }

    public Response<SearchResponse> search(SearchRequest request) throws IOException {
        SearchService service = getFactory().getHttpClient().create(SearchService.class);

        return service.search(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

    public Response<SearchResponse> searchUpdates(SearchUpdatesRequest request) throws IOException {
        SearchService service = getFactory().getHttpClient().create(SearchService.class);

        return service.searchUpdates(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

    public Response<SearchResponse> searchResults(SearchUpdatesRequest request) throws IOException {
        SearchService service = getFactory().getHttpClient().create(SearchService.class);

        return service.searchResults(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

    public Response<SearchStatusResponse> searchStatus(SearchStatusRequest request) throws IOException {
        SearchService service = getFactory().getHttpClient().create(SearchService.class);

        return service.searchStatus(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

    public Response<PreSearchResponse> preSearch(PreSearchRequest request) throws IOException {
        SearchService service = getFactory().getHttpClient().create(SearchService.class);

        return service.preSearch(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

    public Response<SearchResponse> openClarification(OpenClarificationRequest request) throws IOException {
        SearchService service = getFactory().getHttpClient().create(SearchService.class);

        return service.openClarification(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }
}
