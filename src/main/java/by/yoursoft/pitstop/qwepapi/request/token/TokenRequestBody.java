package by.yoursoft.pitstop.qwepapi.request.token;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TokenRequestBody {
    private String authorizationCode;

    private String applicationNum;
}
