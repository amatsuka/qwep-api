package by.yoursoft.pitstop.qwepapi.service;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListFilter;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListRequest;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListRequestBody;
import by.yoursoft.pitstop.qwepapi.response.vendor.VendorItem;
import by.yoursoft.pitstop.qwepapi.response.vendor.VendorListResponse;
import by.yoursoft.pitstop.qwepapi.utils.RequestUtils;

import java.util.List;

public class QwepApiVendorService extends AbstractQwepApiService {

    public QwepApiVendorService(QwepApiFactory qwepApiFactory) {
        super(qwepApiFactory);
    }

    public List<VendorItem> getVendorList() {
        VendorListRequest request = new VendorListRequest();
        request.setRequestBody(new VendorListRequestBody().setFilters(new VendorListFilter()));

        VendorListResponse vendorListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeVendorEndpoint()::getVendorList, request));

        return vendorListResponse.getEntity().getVendors();
    }
}
