package by.yoursoft.pitstop.qwepapi.config;

import lombok.Data;

@Data
class BaseQwepTokenStorage implements QwepTokenStorage {

    private String token;

    @Override
    public void removeToken() {
        token = null;
    }
}
