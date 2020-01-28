package by.yoursoft.pitstop.qwepapi.response.basket.list;

import by.yoursoft.pitstop.qwepapi.response.common.Options;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

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
    private List<Options> options = new LinkedList<>();
}
