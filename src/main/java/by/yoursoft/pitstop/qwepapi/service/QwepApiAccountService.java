package by.yoursoft.pitstop.qwepapi.service;

import by.yoursoft.pitstop.qwepapi.factory.QwepApiFactory;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAdd;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequest;
import by.yoursoft.pitstop.qwepapi.request.account.add.AccountAddRequestBody;
import by.yoursoft.pitstop.qwepapi.request.account.delete.AccountDeleteRequest;
import by.yoursoft.pitstop.qwepapi.request.account.delete.AccountDeleteRequestBody;
import by.yoursoft.pitstop.qwepapi.request.account.list.AccountListRequest;
import by.yoursoft.pitstop.qwepapi.request.account.list.AccountListRequestBody;
import by.yoursoft.pitstop.qwepapi.request.common.CommonFilter;
import by.yoursoft.pitstop.qwepapi.response.account.add.AccountAddResponse;
import by.yoursoft.pitstop.qwepapi.response.account.delete.AccountDeleteResponse;
import by.yoursoft.pitstop.qwepapi.response.account.lest.AccountListResponse;
import by.yoursoft.pitstop.qwepapi.response.common.AccountItem;
import by.yoursoft.pitstop.qwepapi.utils.RequestUtils;

import java.util.List;

import static java.util.Arrays.asList;

public class QwepApiAccountService extends AbstractQwepApiService {

    public QwepApiAccountService(QwepApiFactory qwepApiFactory) {
        super(qwepApiFactory);
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

        AccountAddResponse vendorListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeAccountEndpoint()::addAccount, request));

        return vendorListResponse.getEntity().getAccounts();
    }

    public List<AccountItem> getAccount(boolean promo, boolean enabled){
        AccountListRequest request = new AccountListRequest();
        request.setRequestBody(new AccountListRequestBody()
                .setPromo(promo)
                .setEnabled(enabled));

        AccountListResponse accountListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeAccountEndpoint()::getAccount, request));

        return accountListResponse.getEntity().getAccounts();
    }

    public List<AccountItem> deleteAccount(Long id){
        AccountDeleteRequest request = new AccountDeleteRequest();
        request.setRequestBody(new AccountDeleteRequestBody()
            .setAccounts(asList(new CommonFilter<Long>()
                .setId(id))));
        AccountDeleteResponse accountListResponse = executeWithRefreshTokenIfNeed(() -> RequestUtils.execute(getQwepApiFactory().makeAccountEndpoint()::deleteAccount, request));

        return accountListResponse.getEntity().getAccounts();
    }
}
