package by.yoursoft.pitstop.qwepapi.request.search;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ESearchSortOrder {
    ASC("asc"), DESC("desc");

    private String direction;

    ESearchSortOrder(String direction) {
        this.direction = direction;
    }

    @JsonValue
    public String getDirection() {
        return direction;
    }
}
