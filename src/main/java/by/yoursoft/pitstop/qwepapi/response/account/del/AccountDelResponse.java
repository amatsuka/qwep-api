package by.yoursoft.pitstop.qwepapi.response.account.del;

import by.yoursoft.pitstop.qwepapi.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDelResponse extends BaseResponse<AccountDelResponseBody> {
}
