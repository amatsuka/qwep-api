package by.yoursoft.pitstop.qwepapi;

import by.yoursoft.pitstop.qwepapi.config.BaseQwepFactoryConfig;
import by.yoursoft.pitstop.qwepapi.config.QwepTokenStorage;
import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.search.ESearchSortOrder;
import by.yoursoft.pitstop.qwepapi.request.search.ESearchSortType;
import by.yoursoft.pitstop.qwepapi.request.search.SearchRequestBody;
import by.yoursoft.pitstop.qwepapi.request.search.SearchSort;
import by.yoursoft.pitstop.qwepapi.response.account.add.AccountItem;
import by.yoursoft.pitstop.qwepapi.response.search.SearchResponseBody;
import by.yoursoft.pitstop.qwepapi.response.vendor.VendorItem;
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

        //vendorList(qwepApiService);
        //search(qwepApiService);
    }

    public static void vendorList(QwepApiService qwepApiService) {
        List<VendorItem> vendorList = qwepApiService.getVendorList();
    }

    public static void search(QwepApiService qwepApiService) {
        SearchRequestBuilder builder = qwepApiService.searchRequestBuilder()
                .article("01244")
                .brand("Febi")
                .sorts(asList(new SearchSort()
                        .setSort("article")
                        .setType(ESearchSortType.ITEMS)
                        .setOrder(ESearchSortOrder.ASC)));

        SearchResponseBody search = qwepApiService.search(builder);
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
