package com.platon.browser;//package com.platon.browser;


import com.platon.browser.common.complement.dto.slash.Report;
import com.platon.browser.common.complement.dto.stake.StakeCreate;
import com.platon.browser.common.complement.dto.stake.StakeExit;
import com.platon.browser.common.complement.dto.stake.StakeIncrease;
import com.platon.browser.common.complement.dto.stake.StakeModify;
import com.platon.browser.common.enums.AppStatus;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * @Auther: Chendongming
 * @Date: 2019/9/7 16:35
 * @Description:
 */
public class TestBase {

    static {
        System.setProperty(AppStatus.class.getName(),AppStatus.STOP.name());
    }

    public StakeCreate stakingParam(){
        StakeCreate createStakingParam = StakeCreate.builder()
                .nodeId("0x20a090d94bc5015c9339a46e9ca5d80057a5ef25cc14e71cef67b502ec32949253f046821e80dfb6ff666ef0e0badf58fdb719368c38393f7c40ebcf18d8ed18")
                .stakingHes(new BigDecimal("5000"))
                .nodeName("testNode01")
                .externalId("externalId01")
                .benefitAddr("0xff48d9712d8a55bf603dab28f4645b6985696a61")
                .programVersion("1794")
                .bigVersion("1700")
                .webSite("web_site01")
                .details("details01")
                .isInit(1)
                .stakingBlockNum(new BigInteger("200"))
                .stakingTxIndex(0)
                .stakingAddr("0xb58c7fd25437e2fcf038b948963ffb80276bd44d")
                .joinTime(new Date(System.currentTimeMillis()))
                .txHash("0xaa85c7e85542ac8e8d2428c618130d02723138437d105d06d405f9e735469be7")
                .build();
        return createStakingParam;
    }

    public StakeModify modifyStakingParam(){
        StakeModify modifyStakingParam = StakeModify.builder()
                .nodeName("testNode02")
                .externalId("externalId02")
                .benefitAddr("0xff48d9712d8a55bf603dab28f4645b6985696a61")
                .webSite("web_site01")
                .details("details01")
                .isInit(2)
                .txHash("0xaa85c7e85542ac8e8d2428c618130d02723138437d105d06d405f9e735469be7")
                .stakingBlockNum(new BigInteger("200"))
                .bNum(new BigInteger("300"))
                .time(new java.sql.Date(System.currentTimeMillis()))
                .nodeId("0x20a090d94bc5015c9339a46e9ca5d80057a5ef25cc14e71cef67b502ec32949253f046821e80dfb6ff666ef0e0badf58fdb719368c38393f7c40ebcf18d8ed18")
                .build();
        return modifyStakingParam;
    }

    public StakeIncrease addStakingParam(){
        StakeIncrease addStakingParam = StakeIncrease.builder()
                .amount(new BigDecimal("500000000000000000000000000"))
                .nodeId("0x20a090d94bc5015c9339a46e9ca5d80057a5ef25cc14e71cef67b502ec32949253f046821e80dfb6ff666ef0e0badf58fdb719368c38393f7c40ebcf18d8ed18")
                .txHash("0xaa85c7e85542ac8e8d2428c618130d02723138437d105d06d405f9e735469be7")
                .bNum(new BigInteger("300"))
                .time(new Date(System.currentTimeMillis()))
                .stakingBlockNum(new BigInteger("200"))
                .build();
        return addStakingParam;
    }

    public StakeExit withdrewStakingParam(){
        StakeExit withdrewStakingParam = StakeExit.builder()
                .nodeId("0x20a090d94bc5015c9339a46e9ca5d80057a5ef25cc14e71cef67b502ec32949253f046821e80dfb6ff666ef0e0badf58fdb719368c38393f7c40ebcf18d8ed18")
                .txHash("0xaa85c7e85542ac8e8d2428c618130d02723138437d105d06d405f9e735469be7")
                .bNum(new BigInteger("300"))
                .stakingBlockNum(new BigInteger("200"))
                .time(new Date(System.currentTimeMillis()))
                .stakingReductionEpoch(3)
                .build();
        return withdrewStakingParam;
    }

    public Report reportDuplicateSignParam(){
        Report reportDuplicateSignParam = Report.builder()
                .time(new Date(System.currentTimeMillis()))
                .settingEpoch(3)
                .nodeId("0x20a090d94bc5015c9339a46e9ca5d80057a5ef25cc14e71cef67b502ec32949253f046821e80dfb6ff666ef0e0badf58fdb719368c38393f7c40ebcf18d8ed18")
                .stakingBlockNum(new BigInteger("200"))
                .bNum(new BigInteger("200"))
                .txHash("0xaa85c7e85542ac8e8d2428c618130d02723138437d105d06d405f9e735469be7")
                .slashRate("0.5")
                .slashData("json")
                .benefitAddr("0x02fba14f5e72092c8fca6ced087cd4e7be0d8fc5")
                .codeCurStakingLocked(new BigDecimal("50000000"))
                .codeNodeOptDesc("AMOUNT")
                .codeStatus(2)
                .codeRewardValue(new BigDecimal("1000000000"))
                .build();
        return  reportDuplicateSignParam;
    }
}
