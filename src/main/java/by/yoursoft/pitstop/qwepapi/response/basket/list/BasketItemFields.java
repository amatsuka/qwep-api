package by.yoursoft.pitstop.qwepapi.response.basket.list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketItemFields {
    private int fieldId;
    private String fieldName;
    private int type;
    private String typeName;
    private String defaultValue;
    // вопрос по полю options
}
