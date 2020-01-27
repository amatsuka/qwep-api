package by.yoursoft.pitstop.qwepapi.request.vendor;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VendorListRequestBody {
    private VendorListFilter filters;
}
