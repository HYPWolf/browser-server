package com.platon.browser.service.elasticsearch;

import com.platon.browser.AgentTestBase;
import com.platon.browser.elasticsearch.BlockESRepository;
import com.platon.browser.elasticsearch.dto.Block;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.anyMap;
import static org.mockito.Mockito.doThrow;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EsBlockServiceTest extends AgentTestBase {
    @Mock
    private BlockESRepository blockESRepository;
    @Spy
    private EsBlockService target;

    @Before
    public void setup(){
        ReflectionTestUtils.setField(target, "blockESRepository", blockESRepository);
    }

    /**
     * 根据区块号获取激励池余额
     */
    @Test(expected = Exception.class)
    public void save() throws IOException {
        target.save(Collections.emptySet());
        Set<Block> data = new HashSet<>();
        Block block = new Block();
        block.setNum(33L);
        data.add(block);
        target.save(data);

        data.clear();
        data.add(new Block());
        target.save(data);
        doThrow(new RuntimeException("")).when(blockESRepository).bulkAddOrUpdate(anyMap());
        target.save(data);
    }
}
