package by.yoursoft.pitstop.qwepapi.factory;

import by.yoursoft.pitstop.qwepapi.exception.QwepNetworkException;
import by.yoursoft.pitstop.qwepapi.utils.HttpUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RequiredArgsConstructor
class RetrofitFactory {

    private final String baseUrl;

    private Retrofit instance;

    private final List<Interceptor> interceptors;

    public Retrofit getInstance() {
        if (instance == null) {
            instance = buildSslUnsafe(baseUrl);
        }

        return instance;
    }


    private Retrofit buildSslUnsafe(String baseUrl) {
        try {

            OkHttpClient.Builder builder = HttpUtils.makeBaseBuilder();
            interceptors.forEach(builder::addInterceptor);
            OkHttpClient okHttpClient = builder
                    .build();

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);

            return new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(baseUrl)
                    .addConverterFactory(JacksonConverterFactory.create(mapper))
                    .build();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new QwepNetworkException("extsystem.connection-unsafe.error", e);
        }
    }
}
