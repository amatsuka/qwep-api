package by.yoursoft.pitstop.qwepapi.config;

public interface QwepTokenStorage {
    void setToken(String token);
    String getToken();
    void removeToken();
}
