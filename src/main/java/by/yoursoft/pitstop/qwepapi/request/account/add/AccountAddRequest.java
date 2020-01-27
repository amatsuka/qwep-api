package by.yoursoft.pitstop.qwepapi.request.account.add;

import by.yoursoft.pitstop.qwepapi.request.BaseRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class AccountAddRequest extends BaseRequest<AccountAddRequestBody> {
}
