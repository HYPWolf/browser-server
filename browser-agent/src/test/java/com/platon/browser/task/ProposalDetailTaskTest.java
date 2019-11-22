package com.platon.browser.task;

import com.platon.browser.AgentTestBase;
import com.platon.browser.common.enums.AppStatus;
import com.platon.browser.common.utils.AppStatusUtil;
import com.platon.browser.dao.entity.Proposal;
import com.platon.browser.dao.mapper.CustomProposalMapper;
import com.platon.browser.dao.mapper.ProposalMapper;
import com.platon.browser.dto.CustomProposal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

/**
 * @description:
 * @author: chendongming@juzix.net
 * @create: 2019-11-13 17:13:04
 **/
@RunWith(MockitoJUnitRunner.Silent.class)
public class ProposalDetailTaskTest extends AgentTestBase {
    @Mock
    private CustomProposalMapper customProposalMapper;
    @Mock
    private ProposalMapper proposalMapper;
    @Spy
    private ProposalDetailTask target;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(target, "customProposalMapper", customProposalMapper);
        ReflectionTestUtils.setField(target, "proposalMapper", proposalMapper);
    }

    @Test
    public void test() {
        AppStatusUtil.setStatus(AppStatus.RUNNING);
        when(proposalMapper.selectByExample(any())).thenReturn(new ArrayList<>(proposalList));
        Proposal proposal = proposalList.get(0);
        proposal.setType(CustomProposal.TypeEnum.CANCEL.getCode());
        when(proposalMapper.selectByPrimaryKey(any())).thenReturn(proposal);
        target.cron();
        verify(target, times(1)).cron();

        doThrow(new RuntimeException("")).when(proposalMapper).selectByPrimaryKey(any());
        target.cron();
    }
}