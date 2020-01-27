package by.yoursoft.pitstop.qwepapi;

import by.yoursoft.pitstop.qwepapi.exception.QwepNetworkException;
import by.yoursoft.pitstop.qwepapi.exception.QwepTokenNotValidException;
import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAdd;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequest;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequestBody;
import by.yoursoft.pitstop.qwepapi.request.account.del.AccountDel;
import by.yoursoft.pitstop.qwepapi.request.account.del.AccountDelRequest;
import by.yoursoft.pitstop.qwepapi.request.account.del.AccountDelRequestBody;
import by.yoursoft.pitstop.qwepapi.request.account.get.AccountGet;
import by.yoursoft.pitstop.qwepapi.request.account.get.AccountGetRequest;
import by.yoursoft.pitstop.qwepapi.request.account.get.AccountGetRequestBody;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListFilter;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListRequest;
import by.yoursoft.pitstop.qwepapi.request.vendor.VendorListRequestBody;
import by.yoursoft.pitstop.qwepapi.response.BaseResponse;
import by.yoursoft.pitstop.qwepapi.response.account.add.AccountAddResponse;
import by.yoursoft.pitstop.qwepapi.response.account.del.AccountDelResponse;
import by.yoursoft.pitstop.qwepapi.response.account.get.AccountGetResponse;
import by.yoursoft.pitstop.qwepapi.response.common.AccountItem;
import by.yoursoft.pitstop.qwepapi.response.vendor.VendorItem;
import by.yoursoft.pitstop.qwepapi.response.vendor.VendorListResponse;
import by.yoursoft.pitstop.qwepapi.utils.RequestUtils;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

@RequiredArgsConstructor
public class QwepApiService {

    private final QwepApiFactory qwepApiFactory;

    public List<VendorItem> getVendorList() {
        VendorListRequest request = new VendorListRequest();
        request.setRequestBody(new VendorListRequestBody().setFilters(new VendorListFilter()));

        VendorListResponse vendorListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeVendorEndpoint()::getVendorList, request));

        return vendorListResponse.getEntity().getVendors();
    }

    public List<AccountItem> addAccount(String vid, String bid, String login, String password, String parameters) {
        AccountAddRequest request = new AccountAddRequest();
        request.setRequestBody(new AccountAddRequestBody()
                .setAccounts(asList(new AccountAdd()
                        .setLogin(login)
                        .setVid(vid)
                        .setBid(bid)
                        .setPassword(password)
                        .setParameters(parameters))));

        AccountAddResponse vendorListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeAccountEndpoint()::addAccount, request));

        return vendorListResponse.getEntity().getAccounts();
    }

    public List<AccountItem> getAccount(boolean promo, boolean enabled){
        AccountGetRequest request = new AccountGetRequest();
        request.setRequestBody(new AccountGetRequestBody()
            .setAccounts(asList(new AccountGet()
                .setPromo(promo)
                .setEnabled(enabled))));

        AccountGetResponse accountListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeAccountEndpoint()::getAccount, request));

        return accountListResponse.getEntity().getAccounts();
    }

    public List<AccountItem> delAccount(Long id){
        AccountDelRequest request = new AccountDelRequest();
        request.setRequestBody(new AccountDelRequestBody()
            .setAccounts(asList(new AccountDel()
                .setId(id))));
        AccountDelResponse accountListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(qwepApiFactory.makeAccountEndpoint()::delAccount, request));

        return accountListResponse.getEntity().getAccounts();
    }

    private <R, T extends BaseResponse<R>> T executeWithRefreshTokenIfNeed(Supplier<T> fun) {
        try {
            return fun.get();

        } catch (QwepTokenNotValidException ex) {
            //Если токен просрочен очищаем его в хранилище и пытаемся выполнить запрос снова
            qwepApiFactory.getConfig().getTokenStorage().removeToken();
            try {
                return fun.get();
            } catch (QwepTokenNotValidException ex1) {
                //Перезапрос токена не помог - выбрасываем исключение
                throw new QwepNetworkException("qwep.connection.error", ex1);
            }
        }
    }
}
