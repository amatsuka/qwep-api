package by.yoursoft.pitstop.qwepapi.request.vendorlist;

import by.yoursoft.pitstop.qwepapi.request.common.CommonFilter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.LinkedList;
import java.util.List;

@Data
@Accessors(chain = true)
public class VendorListFilter {
    private List<CommonFilter> vendors = new LinkedList<>();

    private List<CommonFilter> branches = new LinkedList<>();
}
