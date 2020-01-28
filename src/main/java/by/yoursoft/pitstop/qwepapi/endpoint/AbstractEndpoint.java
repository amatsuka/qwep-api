package by.yoursoft.pitstop.qwepapi.endpoint;

import by.yoursoft.pitstop.qwepapi.config.QwepTokenStorage;
import by.yoursoft.pitstop.qwepapi.exception.QwepBadResponseException;
import by.yoursoft.pitstop.qwepapi.exception.QwepNetworkException;
import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.token.TokenRequest;
import by.yoursoft.pitstop.qwepapi.request.token.TokenRequestBody;
import by.yoursoft.pitstop.qwepapi.response.token.TokenResponse;
import by.yoursoft.pitstop.qwepapi.utils.RequestUtils;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.io.IOException;

@RequiredArgsConstructor
abstract class AbstractEndpoint {

    @Getter
    private final QwepApiFactory factory;

    String getToken() {
        QwepTokenStorage tokenStorage = factory.getConfig().getTokenStorage();
        if (tokenStorage.getToken() == null) {
            try {
                tokenStorage.removeToken();
                tokenStorage.setToken(requestToken());

            } catch (IOException | QwepNetworkException ex) {
                throw new QwepNetworkException("qwep.connection.token-error", ex);
            }
        }

        return tokenStorage.getToken();
    }

    public interface AuthEndpointService {
        @POST("/authorization")
        Call<TokenResponse> createToken(@Body TokenRequest body);
    }

    private Call<TokenResponse> createTokenRequest(TokenRequest tokenRequest) {
        AuthEndpointService serivce = factory.getHttpClient().create(AuthEndpointService.class);
        return serivce.createToken(tokenRequest);
    }

    private String requestToken() throws IOException, QwepNetworkException {

        TokenRequest request = new TokenRequest();
        request.setRequestBody(new TokenRequestBody()
                        .setAuthorizationCode(factory.getConfig().getAuthorizationCode())
                        .setApplicationNum(factory.getConfig().getApplicationNum())
                );

        Response<TokenResponse> response = createTokenRequest(request).execute();

        if (!response.isSuccessful()) {
            throw new QwepNetworkException("qwep.connection.error: " + response.code() + " " + response.message());
        }

        TokenResponse body = response.body();

        if (body == null) {
            throw new QwepNetworkException("qwep.connection.error");
        }

        if (body.getErrors() != null) {
            throw new QwepBadResponseException(RequestUtils.makeErrorMessage(body.getErrors()));
        }

        return body.getEntity().getToken();
    }
}
