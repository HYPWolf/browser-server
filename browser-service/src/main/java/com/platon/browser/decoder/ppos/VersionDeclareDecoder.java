package com.platon.browser.decoder.ppos;

import com.platon.browser.param.TxParam;
import com.platon.browser.param.VersionDeclareParam;
import com.alaya.rlp.solidity.RlpList;
import com.alaya.rlp.solidity.RlpString;

import java.math.BigInteger;

/**
 * @description: 创建验证人交易输入参数解码器
 * @author: chendongming@matrixelements.com
 * @create: 2019-11-04 20:13:04
 **/
public class VersionDeclareDecoder {
    private VersionDeclareDecoder(){}
    static TxParam decode(RlpList rootList) {
        // 版本声明
        //声明的节点，只能是验证人/候选人
        String nodeId = InnerContractDecoder.stringResolver((RlpString) rootList.getValues().get(1));
        //声明的版本，有rpc的getProgramVersion接口获取
        BigInteger version =  InnerContractDecoder.bigIntegerResolver((RlpString) rootList.getValues().get(2));
        //声明的版本签名，有rpc的getProgramVersion接口获取
        String versionSign = InnerContractDecoder.stringResolver((RlpString) rootList.getValues().get(3));
        return VersionDeclareParam.builder()
                .activeNode(nodeId)
                .version(version.intValue())
                .versionSigns(versionSign)
                .build();
    }
}
