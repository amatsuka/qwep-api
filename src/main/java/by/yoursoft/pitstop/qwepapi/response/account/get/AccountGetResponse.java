package by.yoursoft.pitstop.qwepapi.response.account.get;

import by.yoursoft.pitstop.qwepapi.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountGetResponse extends BaseResponse<AccountGetResponseBody> {
}
