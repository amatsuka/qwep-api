package by.yoursoft.pitstop.qwepapi.config;

import lombok.Data;
import lombok.experimental.Accessors;
import okhttp3.Interceptor;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public abstract class AbstractQwepFactoryConfig {
    private QwepTokenStorage tokenStorage = new BaseQwepTokenStorage();
    private List<Interceptor> httpInterceptors = new ArrayList<>();
    private String authorizationCode;
    private String applicationNum;
    private String baseUrl;
}
