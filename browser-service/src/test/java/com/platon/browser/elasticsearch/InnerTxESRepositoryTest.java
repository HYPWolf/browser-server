package com.platon.browser.elasticsearch;

import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * @program: InnerTxESRepositoryTest.java
 * @description:
 * @author: Rongjin Zhang
 * @create: 2020/10/16
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class InnerTxESRepositoryTest {
    @Mock
    private RestHighLevelClient client;

    @Spy
    private InnerTxESRepository target;


    @Before
    public void setup() throws Exception {
        ReflectionTestUtils.setField(this.target, "client", this.client);
        ReflectionTestUtils.setField(this.target, "indexName", "client");
        IndicesClient indicesClient = mock(IndicesClient.class);
        when(this.client.indices()).thenReturn(indicesClient);
        CreateIndexResponse createIndexResponse = mock(CreateIndexResponse.class);
        when(indicesClient.create(any(CreateIndexRequest.class), any(RequestOptions.class))).thenReturn(createIndexResponse);
    }

    @Test
    public void createIndexTest() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("", "");
        this.target.createIndex(map);
        this.target.setIndexName("a");
    }

    @Test
    public void existsIndexTest() throws Exception {
        this.target.existsIndex();
    }

    @Test
    public void deleteIndexTest() throws Exception {
        this.target.deleteIndex();
    }

    @Test
    public void addTest() throws Exception {
        this.target.add("Test", "test");
    }

    @Test
    public void existsTest() throws Exception {
        this.target.exists("1");
    }
/*
    @Test
    public void getTest()throws Exception{
        target.get("Test",String.class);
    }*/

    @Test
    public void updateTest() throws Exception {
        this.target.update("Test", "test1");
    }

    @Test
    public void deleteTest() throws Exception {
        this.target.delete("Test");
    }

    @Test
    public void bulkDeleteTest() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Test");
        this.target.bulkDelete(list);
    }

    @Test
    public void bulkAddOrUpdateTest() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("Test", "aaaa");
        this.target.bulkAddOrUpdate(map);
    }


}