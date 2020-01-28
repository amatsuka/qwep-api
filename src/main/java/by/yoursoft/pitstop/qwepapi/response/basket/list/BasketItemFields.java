package by.yoursoft.pitstop.qwepapi.response.basket.list;

import by.yoursoft.pitstop.qwepapi.response.common.Options;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketItemFields {
    private int fieldId;
    private String fieldName;
    private int type;
    private String typeName;
    private String defaultValue;
    private List<Options> options = new LinkedList<>();
}
