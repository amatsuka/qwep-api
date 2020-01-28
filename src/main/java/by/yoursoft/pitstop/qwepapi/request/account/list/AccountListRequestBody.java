package by.yoursoft.pitstop.qwepapi.request.account.list;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class AccountListRequestBody {
    private boolean promo = false;
    private boolean enabled = false;
}
