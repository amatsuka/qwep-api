package by.yoursoft.pitstop.qwepapi.response.account.delete;

import by.yoursoft.pitstop.qwepapi.response.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDeleteResponse extends AbstractResponse<AccountDeleteResponseBody> {
}
