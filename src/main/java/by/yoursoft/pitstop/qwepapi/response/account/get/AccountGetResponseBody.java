package by.yoursoft.pitstop.qwepapi.response.account.get;

import by.yoursoft.pitstop.qwepapi.response.common.AccountItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountGetResponseBody {
    private List<AccountItem> accounts;
}
