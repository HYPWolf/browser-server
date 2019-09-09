package com.platon.browser.enums;

/**
 * 国际化枚举
 *  @file I18nEnum.java
 *  @description 
 *	@author zhangrj
 *  @data 2019年8月31日
 */
public enum I18nEnum {

    // 通用
    SUCCESS,
    PENDING,
    FAILURE,
    UNKNOWN_TYPE,
    UNKNOWN_STATUS,
    UNKNOWN_LOCATION,
    RECORD_NOT_EXIST,

    // 搜索
    SEARCH_KEYWORD_TOO_SHORT,
    SEARCH_KEYWORD_NO_RESULT,
    CHAIN_ID_ERROR,

    // 下载
    DOWNLOAD_EXCEPTION,
    DOWNLOAD_ACCOUNT_CSV_HASH,
    DOWNLOAD_ACCOUNT_CSV_TIME,
    DOWNLOAD_ACCOUNT_CSV_TYPE,
    DOWNLOAD_ACCOUNT_CSV_FEE,
    DOWNLOAD_ACCOUNT_CSV_REWARD, // 奖励
        // 交易
    DOWNLOAD_ACCOUNT_CSV_FROM,
    DOWNLOAD_ACCOUNT_CSV_TO,
    DOWNLOAD_ACCOUNT_CSV_VALUE,
    DOWNLOAD_ACCOUNT_CSV_STATUS,
    DOWNLOAD_ACCOUNT_CSV_VALUE_IN,
    DOWNLOAD_ACCOUNT_CSV_VALUE_OUT,
        // 投票
    DOWNLOAD_ACCOUNT_CSV_TARGET, // 投票目标
    DOWNLOAD_ACCOUNT_CSV_TICKET_COUNT, // 有效票/投票数
    DOWNLOAD_ACCOUNT_CSV_TICKET_PRICE, // 票价
    DOWNLOAD_ACCOUNT_CSV_VOTE_VALUE, // 投票质押

        // 声明
    DOWNLOAD_ACCOUNT_CSV_NODE_NAME, // 节点名称
    DOWNLOAD_ACCOUNT_CSV_DEPOSIT_VALUE, // 质押金

    DOWNLOAD_BLOCK_CSV_NUMBER,
    DOWNLOAD_BLOCK_CSV_TIMESTAMP,
    DOWNLOAD_BLOCK_CSV_TRANSACTION_COUNT,
    DOWNLOAD_BLOCK_CSV_REWARD,
    DOWNLOAD_BLOCK_CSV_TXN_FEE,

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
    NODE_ERROR_NEED_ID_OR_NODE_ID,

    // 交易
    TRANSACTION_TRANSFER,
    TRANSACTION_TRANSFER_SEND,
    TRANSACTION_TRANSFER_RECEIVE,
    TRANSACTION_MPC_TRANSACTION,
    TRANSACTION_CONTRACT_CREATE,
    TRANSACTION_VOTE,
    TRANSACTION_TRANSACTION_EXECUTE,
    TRANSACTION_AUTHORIZATION,

    TRANSACTION_CANDIDATE_DEPOSIT,
    TRANSACTION_CANDIDATE_APPLY_WITHDRAW,
    TRANSACTION_CANDIDATE_WITHDRAW,
    TRANSACTION_VOTE_TICKET,

    TRANSACTION_ERROR_DUPLICATE,
    TRANSACTION_ERROR_NOT_EXIST,



    PENDING_ERROR_DUPLICATE,
    PENDING_ERROR_NOT_EXIST,

    //proposal error
    PROPOSAL_PARAM_ERROR,
    
    TRANSFER,
    CONTRACT_CREATION,
    CONTRACT_EXECUTION,
    OTHERS,
    MPC,
    CREATE_VALIDATOR,
    EDIT_VALIDATOR,
    INCREASE_STAKING,
    EXIT_VALIDATOR,
    DELEGATE,
    UN_DELEGATE,
    CREATE_PROPOSAL_TEXT,
    CREATE_PROPOSAL_UPGRADE,
    CREATE_PROPOSAL_PARAMETER,
    CANCEL_PROPOSAL,
    VOTING_PROPOSAL,
    DECLARE_VERSION,
    REPORT_VALIDATOR,
    CREATE_RESTRICTING,
    DUPLICATE_SIGN,
    ;
}
