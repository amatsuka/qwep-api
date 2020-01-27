package by.yoursoft.pitstop.qwepapi.request.common;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
//TODO Формализовать фильтры коллекции ID, заменить на generic
public class CommonNumFilter {
    private Long id;
}
