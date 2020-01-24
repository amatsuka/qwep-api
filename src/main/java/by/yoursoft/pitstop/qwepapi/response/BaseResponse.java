package by.yoursoft.pitstop.qwepapi.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonRootName("Response")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseResponse<T> {
    @JsonProperty("entity")
    private T entity;

    private List<Error> errors;

    private List<Warning> warnings;
}
