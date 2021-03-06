package com.platon.browser.service;

import com.platon.browser.config.redis.RedisFactory;
import com.platon.browser.enums.I18nEnum;
import com.platon.browser.response.RespPage;
import com.platon.browser.util.I18nUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Set;

/**
 * 基础封装缓存获取逻辑
 * @Auther: Chendongming
 * @Date: 2019/4/11 15:43
 * @Description:
 */
public class CacheBase {

    private final Logger logger = LoggerFactory.getLogger(CacheBase.class);


    protected boolean validateParam(Collection<?> items){
        if(items.isEmpty()){
            // 无更新内容
            logger.debug("Empty Content");
            return false;
        }
        return true;
    }

    protected static class CachePageInfo<T>{
        Set<String> data;
        RespPage<T> page;
    }
    
    protected <T> CachePageInfo <T> getCachePageInfo(String cacheKey,int pageNum,int pageSize,I18nUtil i18n, long maxItemNum, RedisFactory redisFactory){
        RespPage<T> page = new RespPage<>();
        page.setErrMsg(i18n.i(I18nEnum.SUCCESS));
        CachePageInfo<T> cpi = new CachePageInfo<>();
        long pagingTotalCount = redisFactory.createRedisCommands().zsize(cacheKey);
        if(pagingTotalCount>maxItemNum){
            // 如果缓存数量大于maxItemNum，则以maxItemNum作为分页数量
            pagingTotalCount = maxItemNum;
        }
        page.setTotalCount(pagingTotalCount);

        long pageCount = pagingTotalCount/pageSize;
        if(pagingTotalCount%pageSize!=0){
            pageCount+=1;
        }
        page.setTotalPages(pageCount);

        // Redis的缓存分页从索引0开始
        if(pageNum<=0){
            pageNum=1;
        }
        if(pageSize<=0){
            pageSize=1;
        }
        long start = (pageNum-1L)*pageSize;
        long end = (pageNum*pageSize)-1L;
        cpi.data = redisFactory.createRedisCommands().zrevrange(cacheKey, start, end);
        cpi.page = page;
        return cpi;
    }

    protected <T> CachePageInfo <T> getCachePageInfoByStartEnd(String cacheKey,long start,long end,I18nUtil i18n, RedisTemplate<String,String> redisTemplate, long maxItemNum){
        RespPage<T> page = new RespPage<>();
        page.setErrMsg(i18n.i(I18nEnum.SUCCESS));

        CachePageInfo<T> cpi = new CachePageInfo<>();
        Long pagingTotalCount = redisTemplate.opsForZSet().size(cacheKey);
        if(pagingTotalCount!=null&&pagingTotalCount>maxItemNum){
            // 如果缓存数量大于maxItemNum，则以maxItemNum作为分页数量
            pagingTotalCount = maxItemNum;
        }
        page.setTotalCount(pagingTotalCount==null?0L:pagingTotalCount);

        cpi.data = redisTemplate.opsForZSet().reverseRange(cacheKey, start, end);
        cpi.page = page;
        return cpi;
    }

    protected <T> CachePageInfo <T> getCachePageInfoByStartEnd(String cacheKey,long start,long end,I18nUtil i18n,RedisFactory redisFactory){
        RespPage<T> page = new RespPage<>();
        page.setErrMsg(i18n.i(I18nEnum.SUCCESS));

        CachePageInfo<T> cpi = new CachePageInfo<>();
        cpi.data = redisFactory.createRedisCommands().zrevrange(cacheKey, start, end);
        cpi.page = page;
        return cpi;
    }
}
