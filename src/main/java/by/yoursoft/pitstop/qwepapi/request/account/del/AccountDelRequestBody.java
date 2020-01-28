package by.yoursoft.pitstop.qwepapi.request.account.del;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonRootName("Request")
public class AccountDelRequestBody {
    private List<AccountDel> accounts;
}