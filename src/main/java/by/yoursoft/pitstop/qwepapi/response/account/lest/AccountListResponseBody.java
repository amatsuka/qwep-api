package by.yoursoft.pitstop.qwepapi.response.account.lest;

import by.yoursoft.pitstop.qwepapi.response.common.AccountItem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountListResponseBody {
    private List<AccountItem> accounts;
}
