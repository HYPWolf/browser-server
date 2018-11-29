package com.platon.browser.util;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public enum I18nEnum {

    // 通用
    SUCCESS,
    PENDING,
    FAILURE,
    UNKNOWN_TYPE,
    UNKNOWN_STATUS,
    UNKNOWN_LOCATION,

    // 搜索
    SEARCH_KEYWORD_TOO_SHORT,
    SEARCH_KEYWORD_NO_RESULT,
    CHAIN_ID_ERROR,

    // 下载
    DOWNLOAD_EXCEPTION,
    DOWNLOAD_ACCOUNT_CSV_HASH,
    DOWNLOAD_ACCOUNT_CSV_TIME,
    DOWNLOAD_ACCOUNT_CSV_TYPE,
    DOWNLOAD_ACCOUNT_CSV_FROM,
    DOWNLOAD_ACCOUNT_CSV_TO,
    DOWNLOAD_ACCOUNT_CSV_VALUE,
    DOWNLOAD_ACCOUNT_CSV_FEE,
    DOWNLOAD_ACCOUNT_CSV_STATUS,

    DOWNLOAD_BLOCK_CSV_NUMBER,
    DOWNLOAD_BLOCK_CSV_TIMESTAMP,
    DOWNLOAD_BLOCK_CSV_TRANSACTION_COUNT,
    DOWNLOAD_BLOCK_CSV_REWARD,

    // 格式化
    FORMAT_DATE_ERROR,

    // 请求
    REQUEST_INVALID_PARAM,

    // 系统
    SYSTEM_EXCEPTION,

    // 区块
    BLOCK_ERROR_DUPLICATE,
    BLOCK_ERROR_NOT_EXIST,

    // 节点
    NODE_ERROR_DUPLICATE,
    NODE_ERROR_NOT_EXIST,

    // 交易
    TRANSACTION_TRANSFER,
    TRANSACTION_MPC_TRANSACTION,
    TRANSACTION_CONTRACT_CREATE,
    TRANSACTION_VOTE,
    TRANSACTION_TRANSACTION_EXECUTE,
    TRANSACTION_AUTHORIZATION,
    TRANSACTION_ERROR_DUPLICATE,
    TRANSACTION_ERROR_NOT_EXIST,

    PENDING_ERROR_DUPLICATE,
    PENDING_ERROR_NOT_EXIST,
    ;
}
