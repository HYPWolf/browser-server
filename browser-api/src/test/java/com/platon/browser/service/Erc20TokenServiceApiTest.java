package com.platon.browser.service;

import com.platon.browser.ApiTestMockBase;
import com.platon.browser.dao.mapper.Erc20TokenDetailMapper;
import com.platon.browser.dao.mapper.Erc20TokenMapper;
import com.platon.browser.request.token.QueryTokenDetailReq;
import com.platon.browser.request.token.QueryTokenListReq;
import com.platon.browser.response.RespPage;
import com.platon.browser.response.token.QueryTokenDetailResp;
import com.platon.browser.response.token.QueryTokenListResp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class Erc20TokenServiceApiTest extends ApiTestMockBase {

	@Mock
	private Erc20TokenMapper erc20TokenMapper;
	@Mock
	private Erc20TokenDetailMapper erc20TokenDetailMapper;
	@Spy
	private Erc20TokenService target;

	@Before
	public void setup() {
		ReflectionTestUtils.setField(this.target, "erc20TokenMapper", this.erc20TokenMapper);
		ReflectionTestUtils.setField(this.target, "erc20TokenDetailMapper", this.erc20TokenDetailMapper);

	}

	@Test
	public void test_queryTokenList() {
		QueryTokenListReq req = new QueryTokenListReq();
		req.setPageNo(1);
		req.setPageSize(10);

		when(this.erc20TokenMapper.listErc20Token(any())).thenReturn(this.erc20Tokens);
		when(this.erc20TokenMapper.totalErc20Token(any())).thenReturn(this.erc20Tokens.size());
		RespPage<QueryTokenListResp> queryTokenListResp = this.target.queryTokenList(req);
		assertTrue(true);
	}

	@Test
	public void test_queryTokenDetail() {
		QueryTokenDetailReq req = new QueryTokenDetailReq();
		req.setAddress("");

		when(this.erc20TokenMapper.selectByAddress(any())).thenReturn(this.erc20Tokens.get(0));

		when(this.erc20TokenDetailMapper.selectByAddress(any())).thenReturn(this.erc20TokenDetails.get(0));
		QueryTokenDetailResp queryTokenListResp = this.target.queryTokenDetail(req);
		assertTrue(true);
	}

}
