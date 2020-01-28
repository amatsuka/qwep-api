package by.yoursoft.pitstop.qwepapi.response.basket.list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.org.apache.xpath.internal.operations.String;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasketForm {
    private int formId;
    private String formName;
    private String title;
    private String caption;
    private boolean disabled;
    private List<BasketFormFields> basketFormFields = new LinkedList<>();
}
