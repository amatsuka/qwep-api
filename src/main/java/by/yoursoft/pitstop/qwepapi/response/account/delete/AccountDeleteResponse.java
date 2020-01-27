package by.yoursoft.pitstop.qwepapi.response.account.delete;

import by.yoursoft.pitstop.qwepapi.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDeleteResponse extends BaseResponse<AccountDeleteResponseBody> {
}
