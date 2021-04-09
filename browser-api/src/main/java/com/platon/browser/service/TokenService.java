package com.platon.browser.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platon.browser.bean.*;
import com.platon.browser.config.DownFileCommon;
import com.platon.browser.dao.entity.TokenInventory;
import com.platon.browser.dao.entity.TokenInventoryExample;
import com.platon.browser.dao.entity.TokenInventoryKey;
import com.platon.browser.dao.mapper.CustomTokenInventoryMapper;
import com.platon.browser.dao.mapper.CustomTokenMapper;
import com.platon.browser.dao.mapper.TokenInventoryMapper;
import com.platon.browser.enums.I18nEnum;
import com.platon.browser.request.token.QueryTokenDetailReq;
import com.platon.browser.request.token.QueryTokenIdDetailReq;
import com.platon.browser.request.token.QueryTokenIdListReq;
import com.platon.browser.request.token.QueryTokenListReq;
import com.platon.browser.response.RespPage;
import com.platon.browser.response.account.AccountDownload;
import com.platon.browser.response.token.QueryTokenDetailResp;
import com.platon.browser.response.token.QueryTokenIdDetailResp;
import com.platon.browser.response.token.QueryTokenIdListResp;
import com.platon.browser.response.token.QueryTokenListResp;
import com.platon.browser.utils.I18nUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Token模块实现类
 *
 * @author AgentRJ
 * @create 2020-09-23 16:02
 */
@Slf4j
@Service
public class TokenService {

    @Resource
    private CustomTokenMapper customTokenMapper;

    @Resource
    private CustomTokenInventoryMapper customTokenInventoryMapper;

    @Resource
    private I18nUtil i18n;

    @Resource
    private DownFileCommon downFileCommon;

    @Resource
    private TokenInventoryMapper tokenInventoryMapper;


    public RespPage<QueryTokenListResp> queryTokenList(QueryTokenListReq req) {
        // page params: #{offset}, #{size}
        RespPage<QueryTokenListResp> result = new RespPage<>();
        Page<CustomToken> page = new Page<>(req.getPageNo(), req.getPageSize());
        IPage<CustomToken> customTokens = customTokenMapper.selectListByType(page, req.getType());
        List<QueryTokenListResp> data = customTokens.getRecords().stream().map(customToken -> QueryTokenListResp.fromToken(customToken)).collect(Collectors.toList());
        result.init(customTokens, data);
        return result;
    }

    public QueryTokenDetailResp queryTokenDetail(QueryTokenDetailReq req) {
        CustomTokenDetail customTokenDetail = customTokenMapper.selectDetailByAddress(req.getAddress());
        return QueryTokenDetailResp.fromTokenDetail(customTokenDetail);
    }

    /**
     * ARC721 库存列表
     *
     * @param req
     * @return com.platon.browser.response.RespPage<com.platon.browser.response.token.QueryTokenIdListResp>
     * @author huangyongpeng@matrixelements.com
     * @date 2021/1/28
     */
    public RespPage<QueryTokenIdListResp> queryTokenIdList(QueryTokenIdListReq req) {
        RespPage<QueryTokenIdListResp> result = new RespPage<>();
        Page<TokenInventory> page = new Page<>(req.getPageNo(), req.getPageSize());
        TokenInventoryExample example = new TokenInventoryExample();
        TokenInventoryExample.Criteria criteria = example.createCriteria();
        //根据地址、合约地址、tokenid去查询列表
        if (StringUtils.isNotBlank(req.getAddress())) {
            criteria.andOwnerEqualTo(req.getAddress());
        }
        if (StringUtils.isNotBlank(req.getContract())) {
            criteria.andTokenAddressEqualTo(req.getContract());
        }
        if (StringUtils.isNotBlank(req.getTokenId())) {
            criteria.andTokenIdEqualTo(Long.valueOf(req.getTokenId()));
        }
        IPage<TokenInventory> tokenInventorys = tokenInventoryMapper.selectByExample(page, example);
        List<QueryTokenIdListResp> resps = new ArrayList<>();
        tokenInventorys.getRecords().forEach(tokenInventory -> {
            QueryTokenIdListResp resp = QueryTokenIdListResp.fromToken(tokenInventory);
            resps.add(resp);
        });
        result.init(tokenInventorys, resps);
        return result;
    }

    public QueryTokenIdDetailResp queryTokenIdDetail(QueryTokenIdDetailReq req) {
        BigInteger tokenId = StringUtils.isNotBlank(req.getTokenId()) ? new BigInteger(req.getTokenId()) : BigInteger.ZERO;
        TokenInventoryKey tokenInventoryKey = new TokenInventoryKey();
        tokenInventoryKey.setTokenAddress(req.getContract());
        tokenInventoryKey.setTokenId(tokenId);
        CustomTokenInventory customTokenInventory = customTokenInventoryMapper.selectTokenInventory(tokenInventoryKey);
        QueryTokenIdDetailResp.copy(customTokenInventory);
        return QueryTokenIdDetailResp.copy(customTokenInventory);
    }

    public AccountDownload exportTokenId(String address, String contract, String tokenId, String local, String timeZone) {
        Page<TokenInventory> page = new Page<>(1, 30000);
        TokenInventoryExample example = new TokenInventoryExample();
        TokenInventoryExample.Criteria criteria = example.createCriteria();
        //根据地址、合约地址、tokenid去查询列表
        if (StringUtils.isNotBlank(address)) {
            criteria.andOwnerEqualTo(address);
        }
        if (StringUtils.isNotBlank(contract)) {
            criteria.andTokenAddressEqualTo(contract);
        }
        if (StringUtils.isNotBlank(tokenId)) {
            criteria.andTokenIdEqualTo(Long.valueOf(tokenId));
        }
        IPage<TokenInventory> tokenInventorys = tokenInventoryMapper.selectByExample(page, example);
        String[] headers = {
                this.i18n.i(I18nEnum.DOWNLOAD_TOKEN_CSV_NAME, local),
                this.i18n.i(I18nEnum.DOWNLOAD_TOKEN_CSV_TOKEN, local),
                this.i18n.i(I18nEnum.DOWNLOAD_TOKEN_CSV_ADDRESS, local),
                this.i18n.i(I18nEnum.DOWNLOAD_TOKEN_CSV_TOKEN_ID, local),
                this.i18n.i(I18nEnum.DOWNLOAD_TOKEN_CSV_TX_COUNT, local)
        };
        List<Object[]> rows = new ArrayList<>();
        tokenInventorys.getRecords().forEach(tokenInventory -> {
            Object[] row = {tokenInventory.getName(), tokenInventory.getTokenAddress(), tokenInventory.getOwner()
                    , tokenInventory.getTokenId(), tokenInventory.getTokenTxQty()
            };
            rows.add(row);
        });
        return this.downFileCommon.writeDate("Token-Id-" + address + "-" + new Date().getTime() + ".CSV", rows, headers);

    }

}
