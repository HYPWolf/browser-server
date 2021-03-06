package com.platon.browser.decoder.ppos;

import com.platon.browser.param.RestrictingCreateParam;
import com.platon.browser.param.TxParam;
import com.alaya.rlp.solidity.RlpList;
import com.alaya.rlp.solidity.RlpString;

import java.util.List;

/**
 * @description: 创建验证人交易输入参数解码器
 * @author: chendongming@matrixelements.com
 * @create: 2019-11-04 20:13:04
 **/
class RestrictingCreateDecoder {
    private RestrictingCreateDecoder(){}
    static TxParam decode(RlpList rootList) {
        //创建锁仓计划
        //锁仓释放到账账户
        String account = InnerContractDecoder.addressResolver((RlpString) rootList.getValues().get(1));
        // RestrictingPlan 类型的列表（数组）
        List<RestrictingCreateParam.RestrictingPlan> plans = InnerContractDecoder.resolvePlan((RlpString) rootList.getValues().get(2));

        return RestrictingCreateParam.builder()
                .account(account)
                .plans(plans)
                .build();
    }
}
