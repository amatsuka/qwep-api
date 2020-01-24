package by.yoursoft.pitstop.qwepapi.endpoint;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.vendorlist.VendorListRequest;
import by.yoursoft.pitstop.qwepapi.response.vendorlist.VendorListResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VendorEndpoint extends BaseEndpoint {
    public VendorEndpoint(QwepApiFactory factory) {
        super(factory);
    }

    public interface VendorService {
        @POST("/vendors")
        Call<VendorListResponse> getVendorList(@HeaderMap Map<String, String> headers, @Body VendorListRequest body);
    }

    public Response<VendorListResponse> getVendorList(VendorListRequest request) throws IOException {
        VendorService service = getFactory().getHttpClient().create(VendorService.class);

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + getToken());

        return service.getVendorList(headers, request).execute();
    }
}
