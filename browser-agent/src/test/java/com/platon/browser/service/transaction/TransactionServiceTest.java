package com.platon.browser.service.transaction;

import com.platon.browser.AgentTestBase;
import com.platon.browser.analyzer.ppos.*;
import com.platon.browser.bean.EpochMessage;
import com.platon.browser.cache.AddressCache;
import com.platon.browser.cache.NetworkStatCache;
import com.platon.browser.bean.CollectionEvent;
import com.platon.browser.bean.DelegateExitResult;
import com.platon.browser.analyzer.ppos.RestrictingCreateAnalyzer;
import com.platon.browser.analyzer.ppos.ReportAnalyzer;
import com.platon.browser.analyzer.ppos.StakeCreateAnalyzer;
import com.platon.browser.analyzer.ppos.StakeExitAnalyzer;
import com.platon.browser.analyzer.ppos.StakeIncreaseAnalyzer;
import com.platon.browser.analyzer.ppos.StakeModifyAnalyzer;
import com.platon.browser.elasticsearch.dto.DelegationReward;
import com.platon.browser.elasticsearch.dto.NodeOpt;
import com.platon.browser.elasticsearch.dto.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @description: MySQL/ES/Redis启动一致性自检服务测试
 * @author: chendongming@matrixelements.com
 * @create: 2019-11-13 11:41:00
 **/
@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionServiceTest extends AgentTestBase {
    @Mock
    private StakeCreateAnalyzer stakeCreateAnalyzer;
    @Mock
    private StakeModifyAnalyzer stakeModifyAnalyzer;
    @Mock
    private StakeIncreaseAnalyzer stakeIncreaseAnalyzer;
    @Mock
    private StakeExitAnalyzer stakeExitAnalyzer;
    @Mock
    private ReportAnalyzer reportAnalyzer;
    @Mock
    private DelegateCreateAnalyzer delegateCreateAnalyzer;
    @Mock
    private DelegateExitAnalyzer delegateExitAnalyzer;
    @Mock
    private ProposalTextAnalyzer proposalTextAnalyzer;
    @Mock
    private ProposalUpgradeAnalyzer proposalUpgradeAnalyzer;
    @Mock
    private ProposalCancelAnalyzer proposalCancelAnalyzer;
    @Mock
    private ProposalVoteAnalyzer proposalVoteAnalyzer;
    @Mock
    private VersionDeclareAnalyzer proposalVersionAnalyzer;
    @Mock
    private ProposalParameterAnalyzer proposalParameterAnalyzer;
    @Mock
    private RestrictingCreateAnalyzer restrictingCreateAnalyzer;
    @Mock
    private DelegateRewardClaimAnalyzer delegateRewardClaimAnalyzer;
    @Mock
    private NetworkStatCache networkStatCache;
    @Mock
    private AddressCache addressCache;
    @InjectMocks
    @Spy
    private TransactionService target;

    @Before
    public void setup() throws Exception {
    }

    @Test(expected = Exception.class)
    public void test() {
        CollectionEvent event = new CollectionEvent();
        event.setBlock(blockList.get(0));
        event.setEpochMessage(EpochMessage.newInstance());
        event.setTransactions(new ArrayList <>(transactionList));
        Transaction tx = transactionList.get(0);

        tx.setStatus(Transaction.StatusEnum.SUCCESS.getCode());
        tx.setType(Transaction.TypeEnum.TRANSFER.getCode());
        DelegateExitResult der = DelegateExitResult.builder().build();
        when(delegateExitAnalyzer.analyze(any(),any())).thenReturn(der);
        NodeOpt nodeOpt = new NodeOpt();
        when(proposalParameterAnalyzer.analyze(any(),any())).thenReturn(nodeOpt);
        DelegationReward delegationReward = new DelegationReward();
        when(delegateRewardClaimAnalyzer.analyze(any(),any())).thenReturn(delegationReward);
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.STAKE_CREATE.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.STAKE_MODIFY.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.STAKE_INCREASE.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.STAKE_EXIT.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.DELEGATE_CREATE.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.DELEGATE_EXIT.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.PROPOSAL_TEXT.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.PROPOSAL_UPGRADE.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.PROPOSAL_CANCEL.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.PROPOSAL_VOTE.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.VERSION_DECLARE.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.RESTRICTING_CREATE.getCode());
        target.analyze(event);
        tx.setType(Transaction.TypeEnum.REPORT.getCode());
        target.analyze(event);
        verify(target, times(14)).analyze(any());

        doThrow(new RuntimeException("")).when(stakeCreateAnalyzer).analyze(any(),any());
        target.analyze(event);
    }
}
