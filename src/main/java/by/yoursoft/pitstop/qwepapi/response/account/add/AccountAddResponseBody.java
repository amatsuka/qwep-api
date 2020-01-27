package by.yoursoft.pitstop.qwepapi.response.account.add;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountAddResponseBody {
   List<AccountItem> accounts;
}
