package com.platon.browser.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.platon.browser.bean.CustomDelegation;
import com.platon.browser.bean.DelegationAddress;
import com.platon.browser.bean.DelegationStaking;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomDelegationMapper {

    List<CustomDelegation> selectByNodeId(@Param("nodeId") String nodeId);

    List<CustomDelegation> selectByNodeIdList(@Param("nodeIds") List<String> nodeIds);

    IPage<DelegationStaking> selectStakingByNodeId(IPage<DelegationStaking> page, @Param("nodeId") String nodeId);

    IPage<DelegationAddress> selectAddressByAddr(IPage<DelegationAddress> page, @Param("delegateAddr") String delegateAddr);

}
