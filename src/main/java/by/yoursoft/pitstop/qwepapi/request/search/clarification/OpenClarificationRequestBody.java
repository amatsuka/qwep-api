package by.yoursoft.pitstop.qwepapi.request.search.clarification;

import by.yoursoft.pitstop.qwepapi.request.search.SearchSort;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class OpenClarificationRequestBody {
    private String clarificationId;
    private boolean flatView;
    private int type;
    private List<SearchSort> sorts;
}
