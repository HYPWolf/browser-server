package com.platon.browser.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platon.browser.bean.CustomTokenHolder;
import com.platon.browser.bean.TokenHolderCount;
import com.platon.browser.dao.entity.TokenHolder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomTokenHolderMapper {

    IPage<CustomTokenHolder> selectListByParams(Page<CustomTokenHolder> page, @Param("tokenAddress") String tokenAddress, @Param("address") String address, @Param("type") String type);

    /**
     * 查询erc721令牌数量
     *
     * @param tokenAddress
     * @param address
     * @param type
     * @return com.github.pagehelper.Page<com.platon.browser.bean.CustomTokenHolder>
     * @author huangyongpeng@matrixelements.com
     * @date 2021/4/3
     */
    IPage<CustomTokenHolder> findErc721TokenHolder(Page<CustomTokenHolder> page, @Param("tokenAddress") String tokenAddress, @Param("address") String address, @Param("type") String type);

    int batchInsertOrUpdateSelective(@Param("list") List<TokenHolder> list, @Param("selective") TokenHolder.Column... selective);

    /**
     * 批量更新token持有者余额
     *
     * @param list
     * @return int
     * @author huangyongpeng@matrixelements.com
     * @date 2021/3/18
     */
    int batchUpdate(@Param("list") List<TokenHolder> list);

    /**
     * 查询token对应的持有人的数量
     *
     * @param
     * @return java.util.List<com.platon.browser.bean.TokenHolderCount>
     * @author huangyongpeng@matrixelements.com
     * @date 2021/3/17
     */
    List<TokenHolderCount> findTokenHolderCount();

    /**
     * 查询erc721的TokenHolderList
     *
     * @param tokenAddress
     * @param address
     * @return com.github.pagehelper.Page<com.platon.browser.bean.CustomTokenHolder>
     * @author huangyongpeng@matrixelements.com
     * @date 2021/3/19
     */
    IPage<CustomTokenHolder> selectListByERC721(Page<CustomTokenHolder> page, @Param("tokenAddress") String tokenAddress, @Param("address") String address);


}