package com.platon.browser.complement.dao.mapper;

import com.platon.browser.complement.dao.param.BusinessParam;
import org.springframework.transaction.annotation.Transactional;

/*
 * @Auther: dongqile
 * @Date:  2019/11/2
 * @Description:
 */
public interface NewBlockMapper {
    /**
     * 新区块相关数据更新
     */
    @Transactional
    void newBlock(BusinessParam param);
}