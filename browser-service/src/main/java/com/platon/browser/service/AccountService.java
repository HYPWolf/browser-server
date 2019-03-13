package com.platon.browser.service;

import com.platon.browser.dto.account.AccountDetail;
import com.platon.browser.dto.account.AddressDetail;
import com.platon.browser.req.account.AddressDetailReq;

public interface AccountService {
    AddressDetail getAddressDetail(AddressDetailReq req);
    AccountDetail getAccountDetail(String address, String chainId);

}