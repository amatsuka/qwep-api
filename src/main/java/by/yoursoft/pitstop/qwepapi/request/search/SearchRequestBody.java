package by.yoursoft.pitstop.qwepapi.request.search;

import by.yoursoft.pitstop.qwepapi.request.common.CommonFilter;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

@Data
@Accessors(chain = true)
public class SearchRequestBody {

    private String article;

    private String brand;

    private Long timeout = 10000L;

    private String clarification;

    private boolean excludePromo = false;

    private String shortArticle = StringUtils.EMPTY;

    private boolean flatView = false;

    private List<CommonFilter> accounts = new LinkedList<>();

    private List<CommonFilter> vendors = new LinkedList<>();

    private int type = 0;

    private List<SearchSort> sorts = new LinkedList<>();
}
