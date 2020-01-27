package by.yoursoft.pitstop.qwepapi.response.vendor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendorItem {
    private String id;
    private String title;
    private String site;
}
