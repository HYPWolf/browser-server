package com.platon.browser.engine.cache;

import com.platon.browser.dto.CustomAddress;
import com.platon.browser.dto.CustomDelegation;
import com.platon.browser.dto.CustomStaking;
import com.platon.browser.engine.BlockChain;
import com.platon.browser.exception.BusinessException;
import com.platon.browser.exception.NoSuchBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.*;

import static com.platon.browser.engine.BlockChain.*;

/**
 * @Auther: Chendongming
 * @Date: 2019/8/17 18:03
 * @Description: 地址缓存更新器
 */
@Component
public class AddressCacheUpdater {
    @Autowired
    private BlockChain bc;

    class Stat{
        BigInteger stakingValue,delegateValue,stakingRedeemed,delegateRedeemed,redeemedValue,candidateCount,delegateHes,delegateLocked,delegateUnlock,delegateReduction;
        public void reset(){
            this.stakingValue = BigInteger.ZERO;
            this.delegateValue = BigInteger.ZERO;
            this.stakingRedeemed = BigInteger.ZERO;
            this.delegateRedeemed = BigInteger.ZERO;
            this.redeemedValue = BigInteger.ZERO;
            this.candidateCount = BigInteger.ZERO;
            this.delegateHes = BigInteger.ZERO;
            this.delegateLocked = BigInteger.ZERO;
            this.delegateUnlock = BigInteger.ZERO;
            this.delegateReduction = BigInteger.ZERO;
        }
    }
    private Stat stat = new Stat();

    /**
     * 2.补充统计地址相关数据，在批量采集后批量入库前执行
     *      a.staking_value  质押的金额
     *      b.delegate_value  委托的金额
     *      c.redeemed_value   赎回中的金额，包含委托和质押
     *      d.candidate_count   已委托的验证人
     *      e.delegate_hes   未锁定委托
     *      f.delegate_locked   已锁定委托
     *      g.delegate_unlock  已经解锁的
     *      h.delegate_reduction  赎回中的
     *
     */
    public void updateAddressStatistics () throws BusinessException {
        // 所有质押 <发起质押地址-质押实体列表> 映射
        Map<String, Set<CustomStaking>> addressStakingMap = new HashMap<>();
        NODE_CACHE.getAllStaking().forEach(staking -> {
            Set<CustomStaking> stakingSet = addressStakingMap.computeIfAbsent(staking.getStakingAddr(), k -> new HashSet<>());
            stakingSet.add(staking);
        });
        // 非历史状态的委托 <发起委托地址-委托实体列表> 映射
        Map<String,Set<CustomDelegation>> addressDelegationMap = new HashMap<>();
        NODE_CACHE.getDelegationByIsHistory(CustomDelegation.YesNoEnum.NO).forEach(delegation -> {
            Set<CustomDelegation> delegationSet = addressDelegationMap.computeIfAbsent(delegation.getDelegateAddr(), k -> new HashSet<>());
            delegationSet.add(delegation);
        });
        // 统计每个地址的质押信息和委托信息
        for (CustomAddress address:ADDRESS_CACHE.getAllAddress()) {
            stat.reset(); // 重置统计bean状态, 复用实例，避免大量创建对象
            // 查看当前地址是否有质押信息, 若有, 则统计当前地址质押相关金额
            Set<CustomStaking> stakingSet = addressStakingMap.get(address.getAddress());
            if(stakingSet!=null){
                stakingSet.forEach(staking -> {
                    stat.stakingValue = stat.stakingValue.add(staking.integerStakingHas().add(staking.integerStakingLocked()));
                    stat.stakingRedeemed = stat.stakingRedeemed.add(staking.integerStakingReduction());
                });
            }
            // 查看当前地址是否有委托信息, 若有, 则统计当前地址委托相关金额
            Set<CustomDelegation> delegationSet = addressDelegationMap.get(address.getAddress());
            if(delegationSet!=null){
                for(CustomDelegation delegation:delegationSet){
                    stat.delegateValue = stat.delegateValue.add(delegation.integerDelegateHas().add(delegation.integerDelegateLocked()));
                    stat.delegateRedeemed = stat.delegateRedeemed.add(delegation.integerDelegateReduction());
                    stat.delegateHes = stat.delegateHes.add(delegation.integerDelegateHas());
                    stat.delegateLocked = stat.delegateLocked.add(delegation.integerDelegateLocked());
                    stat.delegateReduction = stat.delegateReduction.add(delegation.integerDelegateReduction());
                    stat.candidateCount = stat.candidateCount.add(BigInteger.ONE);
                    Integer status = 0;
                    try {
                        CustomStaking staking = NODE_CACHE.getStaking(delegation.getNodeId(),delegation.getStakingBlockNum());
                        status = staking.getStatus();
                    } catch (NoSuchBeanException e) {
                        throw new BusinessException(e.getMessage());
                    }
                    if (status.equals(CustomStaking.StatusEnum.EXITING.code) || status.equals(CustomStaking.StatusEnum.EXITED.code)) {
                        stat.delegateUnlock = stat.delegateUnlock.add(delegation.integerDelegateHas());
                    }
                }
            }
            stat.redeemedValue = stat.stakingRedeemed.add(stat.delegateRedeemed);

            //address引用对象更新
            address.setStakingValue(stat.stakingValue.toString());
            address.setDelegateValue(stat.delegateValue.toString());
            address.setRedeemedValue(stat.redeemedValue.toString());
            address.setCandidateCount(stat.candidateCount.intValue());
            address.setDelegateValue(stat.delegateHes.toString());
            address.setDelegateLocked(stat.delegateLocked.toString());
            address.setDelegateUnlock(stat.delegateUnlock.toString());
            address.setDelegateReduction(stat.delegateReduction.toString());
            // 把地址信息改动暂存至待更新列表
            STAGE_DATA.getAddressStage().updateAddress(address);
        }
    }
}