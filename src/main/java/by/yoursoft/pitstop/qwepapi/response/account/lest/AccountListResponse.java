package by.yoursoft.pitstop.qwepapi.response.account.lest;

import by.yoursoft.pitstop.qwepapi.response.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountListResponse extends AbstractResponse<AccountListResponseBody> {
}
