package by.yoursoft.pitstop.qwepapi.endpoint;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequest;
import by.yoursoft.pitstop.qwepapi.response.account.add.AccountAddResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccountEndpoint extends BaseEndpoint {
    public AccountEndpoint(QwepApiFactory factory) {
        super(factory);
    }

    public interface AccountService {
        @POST("/accounts/add")
        Call<AccountAddResponse> addAccount(@HeaderMap Map<String, String> headers, @Body AccountAddRequest body);
    }

    public Response<AccountAddResponse> addAccount(AccountAddRequest request) throws IOException {
        AccountService service = getFactory().getHttpClient().create(AccountService.class);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + getToken());

        return service.addAccount(headers, request).execute();
    }
}
