package by.yoursoft.pitstop.qwepapi.response.vendorlist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendorListResponseBody {
   List<VendorItem> vendors;
}
