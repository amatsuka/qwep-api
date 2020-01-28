package by.yoursoft.pitstop.qwepapi.response.common;

import by.yoursoft.pitstop.qwepapi.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusResponse extends BaseResponse<StatusResponseBody> {
}
