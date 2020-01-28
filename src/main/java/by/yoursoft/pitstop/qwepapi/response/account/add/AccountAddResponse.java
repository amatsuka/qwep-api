package by.yoursoft.pitstop.qwepapi.response.account.add;

import by.yoursoft.pitstop.qwepapi.response.AbstractResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountAddResponse extends AbstractResponse<AccountAddResponseBody> {
}
