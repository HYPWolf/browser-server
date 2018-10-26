package com.platon.browser.common.dto.transaction;

import lombok.Data;

@Data
public class AllTransactionList {
    private String txHash;
    private long blockTime;
    private String from;
    private String to;
    private String value;
    private String actualTxCost;
    private int txReceiptStatus;
    private String txType;
    private long serverTime;
    private String failReason;
}
