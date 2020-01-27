package by.yoursoft.pitstop.qwepapi.response.account.add;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountItem {
    private Long id;
    private String vid;
    private String bid;
    private String login;
}
