package by.yoursoft.pitstop.qwepapi.endpoint;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequest;
import by.yoursoft.pitstop.qwepapi.request.account.del.AccountDelRequest;
import by.yoursoft.pitstop.qwepapi.request.account.get.AccountGetRequest;
import by.yoursoft.pitstop.qwepapi.response.account.add.AccountAddResponse;
import by.yoursoft.pitstop.qwepapi.response.account.del.AccountDelResponse;
import by.yoursoft.pitstop.qwepapi.response.account.get.AccountGetResponse;
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

        @POST("/accounts/get")
        Call<AccountGetResponse> getAccount(@HeaderMap Map<String, String> headers, @Body AccountGetRequest body);

        @POST("/accounts/delete")
        Call<AccountDelResponse> delAccount(@HeaderMap Map<String, String> headers, @Body AccountDelRequest body);
    }

    public Response<AccountAddResponse> addAccount(AccountAddRequest request) throws IOException {
        AccountService service = getFactory().getHttpClient().create(AccountService.class);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + getToken());

        return service.addAccount(headers, request).execute();
    }

    public Response<AccountGetResponse> getAccount(AccountGetRequest request) throws IOException {
        AccountService service = getFactory().getHttpClient().create(AccountService.class);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + getToken());

        return service.getAccount(headers, request).execute();
    }

    public Response<AccountDelResponse> delAccount(AccountDelRequest request) throws IOException{
        AccountService service = getFactory().getHttpClient().create(AccountService.class);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + getToken());

        return service.delAccount(headers, request).execute();
    }

}
