package by.yoursoft.pitstop.qwepapi.request.vendor;

import by.yoursoft.pitstop.qwepapi.request.common.CommonFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.LinkedList;
import java.util.List;

@Data
@Accessors(chain = true)
public class VendorListFilter {
    private List<CommonFilter<String>> vendors = new LinkedList<>();
    private List<CommonFilter<String>> branches = new LinkedList<>();
}
