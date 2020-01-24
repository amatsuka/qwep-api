package by.yoursoft.pitstop.qwepapi;

import by.yoursoft.pitstop.qwepapi.config.BaseQwepFactoryConfig;
import by.yoursoft.pitstop.qwepapi.config.QwepTokenStorage;
import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.response.vendorlist.VendorItem;
import lombok.RequiredArgsConstructor;
import okhttp3.logging.HttpLoggingInterceptor;

import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        String baseUrl = "http://userapi.qwep.ru";
        String apiKey = "F3F6FC0D38B8AFDCB888";
        String applicationNum = "1";

        String token = "2338cff301f54753364a88697573ced1e1698ca6";

        BaseQwepFactoryConfig baseQwepFactoryConfig = new BaseQwepFactoryConfig();
        baseQwepFactoryConfig
                .setApplicationNum(applicationNum)
                .setAuthorizationCode(apiKey)
                .setBaseUrl(baseUrl)
                .setTokenStorage(new StubStorage(token))
                .setHttpInterceptors(asList(new HttpLoggingInterceptor()));

        QwepApiFactory qwepApiFactory = new QwepApiFactory(baseQwepFactoryConfig);

        QwepApiService qwepApiService = new QwepApiService(qwepApiFactory);

        List<VendorItem> vendorList = qwepApiService.getVendorList();
    }

    @RequiredArgsConstructor
    public static class StubStorage implements QwepTokenStorage {

        private final String token;

        @Override
        public void setToken(String token) {

        }

        @Override
        public String getToken() {
            return token;
        }

        @Override
        public void removeToken() {

        }
    }
}
