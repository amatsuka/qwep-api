package by.yoursoft.pitstop.qwepapi;

import by.yoursoft.pitstop.qwepapi.request.common.CommonFilter;
import by.yoursoft.pitstop.qwepapi.request.search.SearchRequestBody;
import by.yoursoft.pitstop.qwepapi.request.search.SearchSort;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class SearchRequestBuilder {
    private String article;

    private String brand;

    private Long timeout = 10000L;

    private String clarification;

    private boolean excludePromo = false;

    private String shortArticle = StringUtils.EMPTY;

    private List<CommonFilter<String>> accounts = new LinkedList<>();

    private List<CommonFilter<String>> vendors = new LinkedList<>();

    private int type = 0;

    private List<SearchSort> sorts = new LinkedList<>();

    SearchRequestBuilder() {
    }

    public SearchRequestBuilder article(String article) {
        this.article = article;
        return this;
    }

    public SearchRequestBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    public SearchRequestBuilder timeout(Long timeout) {
        this.timeout = timeout;
        return this;
    }

    public SearchRequestBuilder clarification(String clarification) {
        this.clarification = clarification;
        return this;
    }

    public SearchRequestBuilder excludePromo(boolean excludePromo) {
        this.excludePromo = excludePromo;
        return this;
    }

    public SearchRequestBuilder shortArticle(String shortArticle) {
        this.shortArticle = shortArticle;
        return this;
    }

    public SearchRequestBuilder accounts(List<CommonFilter<String>> accounts) {
        this.accounts = accounts;
        return this;
    }

    public SearchRequestBuilder vendors(List<CommonFilter<String>> vendors) {
        this.vendors = vendors;
        return this;
    }

    public SearchRequestBuilder type(int type) {
        this.type = type;
        return this;
    }

    public SearchRequestBuilder sorts(List<SearchSort> sorts) {
        this.sorts = sorts;
        return this;
    }

    public SearchRequestBody build() {
        return new SearchRequestBody()
                .setArticle(article)
                .setBrand(brand)
                .setClarification(clarification)
                .setExcludePromo(excludePromo)
                .setShortArticle(shortArticle)
                .setAccounts(accounts)
                .setVendors(vendors)
                .setType(type)
                .setSorts(sorts);
    }
}