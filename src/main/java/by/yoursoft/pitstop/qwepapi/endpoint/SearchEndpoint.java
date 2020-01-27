package by.yoursoft.pitstop.qwepapi.endpoint;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequest;
import by.yoursoft.pitstop.qwepapi.request.search.SearchRequest;
import by.yoursoft.pitstop.qwepapi.response.account.add.AccountAddResponse;
import by.yoursoft.pitstop.qwepapi.response.search.SearchResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SearchEndpoint extends BaseEndpoint {
    public SearchEndpoint(QwepApiFactory factory) {
        super(factory);
    }

    public interface SearchService {
        @POST("/search")
        Call<SearchResponse> search(@HeaderMap Map<String, String> headers, @Body SearchRequest body);
    }

    public Response<SearchResponse> search(SearchRequest request) throws IOException {
        SearchService service = getFactory().getHttpClient().create(SearchService.class);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + getToken());

        return service.search(headers, request).execute();
    }
}
