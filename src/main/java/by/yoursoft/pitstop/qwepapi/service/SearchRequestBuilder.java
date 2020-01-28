package by.yoursoft.pitstop.qwepapi.service;

import by.yoursoft.pitstop.qwepapi.request.common.CommonFilter;
import by.yoursoft.pitstop.qwepapi.request.search.SearchRequestBody;
import by.yoursoft.pitstop.qwepapi.request.search.SearchSort;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

@Setter
@Accessors(chain = true)
public class SearchRequestBuilder {
    private String article;

    private String brand;

    private Long timeout = 10_000L;

    private String clarification;

    private boolean excludePromo;

    private String shortArticle = StringUtils.EMPTY;

    private List<CommonFilter<String>> accounts = new LinkedList<>();

    private List<CommonFilter<String>> vendors = new LinkedList<>();

    private int type;

    private List<SearchSort> sorts = new LinkedList<>();

    /* default */ SearchRequestBuilder() {
        /*empty*/
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
                .setSorts(sorts)
                .setTimeout(timeout);
    }
}