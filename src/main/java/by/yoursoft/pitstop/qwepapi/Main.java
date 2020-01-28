package by.yoursoft.pitstop.qwepapi;

import by.yoursoft.pitstop.qwepapi.config.BaseQwepFactoryConfig;
import by.yoursoft.pitstop.qwepapi.config.QwepTokenStorage;
import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.search.ESearchSortOrder;
import by.yoursoft.pitstop.qwepapi.request.search.ESearchSortType;
import by.yoursoft.pitstop.qwepapi.request.search.SearchSort;
import by.yoursoft.pitstop.qwepapi.response.basket.add.BasketAddResponseBody;
import by.yoursoft.pitstop.qwepapi.response.basket.list.BasketItemList;
import by.yoursoft.pitstop.qwepapi.response.basket.list.BasketListResponse;
import by.yoursoft.pitstop.qwepapi.response.search.SearchResponseBody;
import by.yoursoft.pitstop.qwepapi.response.vendor.VendorItem;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.RequiredArgsConstructor;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) throws IOException {
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

    public static void searchUpdates(QwepApiService qwepApiService, String searchId) {
        qwepApiService.searchUpdates(searchId, new LinkedList<>());
    }

    public static void searchResults(QwepApiService qwepApiService, String searchId) {
        qwepApiService.searchResults(searchId, new LinkedList<>());
    }

    public static void searchStatus(QwepApiService qwepApiService, String searchId) {
        qwepApiService.searchStatus(searchId);
    }

    public static void preSearch(QwepApiService qwepApiService) {
        qwepApiService.preSearch("a12345", new LinkedList<>(), new LinkedList<>());
    }

    public static void openClarification(QwepApiService qwepApiService) {
        qwepApiService.openClarification("a12345", new LinkedList<>(), 0);
    }

    public static void getBasket(QwepApiService qwepApiService){
        qwepApiService.getBasket((long)915067);

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
