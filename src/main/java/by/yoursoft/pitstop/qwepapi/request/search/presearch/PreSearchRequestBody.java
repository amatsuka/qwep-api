package by.yoursoft.pitstop.qwepapi.request.search.presearch;

import by.yoursoft.pitstop.qwepapi.request.common.CommonFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.LinkedList;
import java.util.List;

@Data
@Accessors(chain = true)
public class PreSearchRequestBody {
    private String article;
    private boolean excludePromo = false;
    private List<CommonFilter> accounts = new LinkedList<>();
    private List<CommonFilter> vendors = new LinkedList<>();
}