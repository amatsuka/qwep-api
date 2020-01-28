package by.yoursoft.pitstop.qwepapi.endpoint;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequest;
import by.yoursoft.pitstop.qwepapi.request.account.delete.AccountDeleteRequest;
import by.yoursoft.pitstop.qwepapi.request.account.list.AccountListRequest;
import by.yoursoft.pitstop.qwepapi.response.account.add.AccountAddResponse;
import by.yoursoft.pitstop.qwepapi.response.account.delete.AccountDeleteResponse;
import by.yoursoft.pitstop.qwepapi.response.account.get.AccountGetResponse;
import by.yoursoft.pitstop.qwepapi.utils.HttpUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.Map;

public class AccountEndpoint extends AbstractEndpoint {
    public AccountEndpoint(QwepApiFactory factory) {
        super(factory);
    }

    private interface AccountService {
        @POST("/accounts/add")
        Call<AccountAddResponse> addAccount(@HeaderMap Map<String, String> headers, @Body AccountAddRequest body);

        @POST("/accounts/list")
        Call<AccountGetResponse> getAccount(@HeaderMap Map<String, String> headers, @Body AccountListRequest body);

        @POST("/accounts/delete")
        Call<AccountDeleteResponse> deleteAccount(@HeaderMap Map<String, String> headers, @Body AccountDeleteRequest body);
    }

    public Response<AccountAddResponse> addAccount(AccountAddRequest request) throws IOException {
        AccountService service = getFactory().getHttpClient().create(AccountService.class);

        return service.addAccount(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

    public Response<AccountGetResponse> getAccount(AccountListRequest request) throws IOException {
        AccountService service = getFactory().getHttpClient().create(AccountService.class);

        return service.getAccount(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

    public Response<AccountDeleteResponse> deleteAccount(AccountDeleteRequest request) throws IOException{
        AccountService service = getFactory().getHttpClient().create(AccountService.class);

        return service.deleteAccount(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }

}
