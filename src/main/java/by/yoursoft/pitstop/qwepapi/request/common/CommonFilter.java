package by.yoursoft.pitstop.qwepapi.request.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CommonFilter<T> {
    private T id;
}
