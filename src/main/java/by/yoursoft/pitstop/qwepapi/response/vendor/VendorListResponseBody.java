package by.yoursoft.pitstop.qwepapi.response.vendor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendorListResponseBody {
   List<VendorItem> vendors;
}
