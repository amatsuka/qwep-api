package by.yoursoft.pitstop.qwepapi.request.account.get;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AccountGet {
    private boolean promo = false;
    private boolean enabled = false;
}
