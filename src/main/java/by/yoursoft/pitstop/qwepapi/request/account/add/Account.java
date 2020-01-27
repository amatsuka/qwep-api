package by.yoursoft.pitstop.qwepapi.request.account.add;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Account {
    private String vid;
    private String bid;
    private String login;
    private String password;
    private String parameters;
}
