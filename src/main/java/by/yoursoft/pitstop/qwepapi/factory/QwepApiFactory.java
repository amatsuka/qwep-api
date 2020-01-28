package by.yoursoft.pitstop.qwepapi.factory;

import by.yoursoft.pitstop.qwepapi.config.AbstractQwepFactoryConfig;
import by.yoursoft.pitstop.qwepapi.endpoint.AccountEndpoint;
import by.yoursoft.pitstop.qwepapi.endpoint.BasketEndpoint;
import by.yoursoft.pitstop.qwepapi.endpoint.SearchEndpoint;
import by.yoursoft.pitstop.qwepapi.endpoint.VendorEndpoint;
import lombok.Getter;
import retrofit2.Retrofit;

public class QwepApiFactory {
    private final RetrofitFactory retrofitFactory;

    @Getter
    private final AbstractQwepFactoryConfig config;

    public QwepApiFactory(AbstractQwepFactoryConfig config) {
        this.config = config;
        this.retrofitFactory = new RetrofitFactory(config.getBaseUrl(), config.getHttpInterceptors());
    }

    public Retrofit getHttpClient() {
        return retrofitFactory.getInstance();
    }

    public VendorEndpoint makeVendorEndpoint() {
        return new VendorEndpoint(this);
    }

    public AccountEndpoint makeAccountEndpoint() {
        return new AccountEndpoint(this);
    }

    public BasketEndpoint makeBasketEndpoint() {
        return new BasketEndpoint(this);
    }

    public SearchEndpoint makeSearchEndpoint() {
        return new SearchEndpoint(this);
    }

}
