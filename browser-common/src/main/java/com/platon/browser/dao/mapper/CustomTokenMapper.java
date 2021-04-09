package com.platon.browser.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.platon.browser.bean.CustomToken;
import com.platon.browser.bean.CustomTokenDetail;
import com.platon.browser.dao.entity.Token;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomTokenMapper {

    IPage<CustomToken> selectListByType(Page<CustomToken> page, @Param("type") String type);

    CustomTokenDetail selectDetailByAddress(@Param("address") String address);

    int batchInsertOrUpdateSelective(@Param("list") List<Token> list, @Param("selective") Token.Column... selective);

}