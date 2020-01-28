package by.yoursoft.pitstop.qwepapi.request.search.updates;

import by.yoursoft.pitstop.qwepapi.request.search.SearchSort;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.LinkedList;
import java.util.List;

@Data
@Accessors(chain = true)
public class SearchUpdatesRequestBody {

    private String searchId;

    private boolean flatView;

    private List<SearchSort> sorts = new LinkedList<>();
}
