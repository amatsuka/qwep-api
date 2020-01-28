package by.yoursoft.pitstop.qwepapi.request.search;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SearchSort {
    private ESearchSortType type;
    private String sort;
    private ESearchSortOrder order;
    private boolean openAllClarifications;
}
