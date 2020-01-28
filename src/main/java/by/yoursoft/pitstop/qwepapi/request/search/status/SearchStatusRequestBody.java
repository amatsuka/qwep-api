package by.yoursoft.pitstop.qwepapi.request.search.status;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SearchStatusRequestBody {
    private String searchId;
}
