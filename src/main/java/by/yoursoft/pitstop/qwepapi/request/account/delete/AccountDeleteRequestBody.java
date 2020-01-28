package by.yoursoft.pitstop.qwepapi.request.account.delete;

import by.yoursoft.pitstop.qwepapi.request.common.CommonFilter;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class AccountDeleteRequestBody {
    private List<CommonFilter<Long>> accounts;
}
