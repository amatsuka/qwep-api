package by.yoursoft.pitstop.qwepapi.endpoint;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListRequest;
import by.yoursoft.pitstop.qwepapi.response.vendor.VendorListResponse;
import by.yoursoft.pitstop.qwepapi.utils.HttpUtils;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.Map;

public class VendorEndpoint extends AbstractEndpoint {
    public VendorEndpoint(QwepApiFactory factory) {
        super(factory);
    }

    private interface VendorService {
        @POST("/vendors")
        Call<VendorListResponse> getVendorList(@HeaderMap Map<String, String> headers, @Body VendorListRequest body);
    }

    public Response<VendorListResponse> getVendorList(VendorListRequest request) throws IOException {
        VendorService service = getFactory().getHttpClient().create(VendorService.class);

        return service.getVendorList(HttpUtils.makeAuthHeader(getToken()), request).execute();
    }
}
