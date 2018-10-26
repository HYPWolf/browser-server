package com.platon.browser.common.req.transaction;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class AllTransactionDetailReq {
    @NotBlank(message = "链ID不能为空！")
    private String cid;
    @NotBlank(message = "交易Hash不能为空！")
    private String txHash;
}
