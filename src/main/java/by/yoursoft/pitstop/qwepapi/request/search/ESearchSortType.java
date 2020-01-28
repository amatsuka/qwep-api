package by.yoursoft.pitstop.qwepapi.request.search;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ESearchSortType {
    CLARIFICATONS("clarifications"), ITEMS("items");

    private String type;

    ESearchSortType(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
