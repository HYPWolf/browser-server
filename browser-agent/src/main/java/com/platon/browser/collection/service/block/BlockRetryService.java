package com.platon.browser.collection.service.block;

import com.platon.browser.client.PlatOnClient;
import com.platon.browser.collection.exception.CollectionBlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.PlatonBlock;

import java.io.IOException;
import java.math.BigInteger;

/**
 * @Auther: Chendongming
 * @Date: 2019/10/30 10:14
 * @Description: 带重试功能的区块服务
 */
@Slf4j
@Service
public class BlockRetryService {

    @Autowired
    private PlatOnClient platOnClient;

    /**
     * 根据区块号获取区块信息
     * @param blockNumber
     * @return 带有交易信息的区块信息
     * @throws
     */
    @Retryable(value = Exception.class, maxAttempts = Integer.MAX_VALUE)
    PlatonBlock getBlock(Long blockNumber) throws IOException {
        try {
            log.debug("{}({})",Thread.currentThread().getStackTrace()[1].getMethodName(),blockNumber);
            DefaultBlockParameter dp = DefaultBlockParameter.valueOf(BigInteger.valueOf(blockNumber));
            return platOnClient.getWeb3j().platonGetBlockByNumber(dp,true).send();
        }catch (Exception e){
            log.error("",e);
            throw e;
        }
    }

    /**
     * 检查当前区块号是否合法
     * @param currentBlockNumber
     * @throws
     */
    private BigInteger latestBlockNumber;
    @Retryable(value = Exception.class, maxAttempts = Integer.MAX_VALUE)
    void checkBlockNumber(Long currentBlockNumber) throws IOException, CollectionBlockException {
        try {
            if(latestBlockNumber==null||currentBlockNumber>latestBlockNumber.longValue()) {
                // 如果记录的链上最新区块号为空,或当前区块号大于记录的链上最新区块号,则更新链上最新区块号
                latestBlockNumber = platOnClient.getWeb3j().platonBlockNumber().send().getBlockNumber();
            }
            if(currentBlockNumber>latestBlockNumber.longValue()){
                // 如果当前区块号仍然大于更新后的链上最新区块号
                throw new CollectionBlockException("currentBlockNumber("+currentBlockNumber+")>latestBlockNumber("+latestBlockNumber+"), wait for chain");
            }
        }catch (Exception e){
            log.debug("",e);
            throw e;
        }
    }
}