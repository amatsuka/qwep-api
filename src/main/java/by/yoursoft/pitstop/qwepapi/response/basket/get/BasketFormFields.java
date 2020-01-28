package by.yoursoft.pitstop.qwepapi.response.basket.get;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketFormFields {
    private int fieldId;
    private String fieldName;
    private String title;
    private String validation;
    private boolean required;
    private String error;
    private int type;
    private String typeName;
    private String defaultValue;
    private String fields;
    // вопрос по полю options
}
