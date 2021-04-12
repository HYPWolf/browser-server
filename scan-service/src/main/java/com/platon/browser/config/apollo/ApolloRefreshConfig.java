package com.platon.browser.config.apollo;

import cn.hutool.core.util.StrUtil;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import com.platon.browser.bean.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * apollo结合springcloudconfig实现动态刷新
 * 在使用@value和@ConfigurationProperties对应的类上添加@RefreshScope即可实现动态刷新
 *
 * @author huangyongpeng@matrixelements.com
 * @date 2021/4/10
 */
@Slf4j
@Component
public class ApolloRefreshConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Resource
    RefreshScope refreshScope;

    @Resource
    private LoggingSystem loggingSystem;

    /**
     * 监听配置
     *
     * @param changeEvent
     * @return void
     * @author huangyongpeng@matrixelements.com
     * @date 2021/4/10
     */
    @ApolloConfigChangeListener(value = {"scan-api-common", "scan-api-server-yml.yml"})
    private void onChange(ConfigChangeEvent changeEvent) {
        refreshLoggingLevels(changeEvent);
        refreshProperties(changeEvent);
    }

    /**
     * 刷新配置
     *
     * @param changeEvent
     * @return void
     * @author huangyongpeng@matrixelements.com
     * @date 2021/4/10
     */
    private void refreshProperties(ConfigChangeEvent changeEvent) {
        for (String changedKey : changeEvent.changedKeys()) {
            ConfigChange configChange = changeEvent.getChange(changedKey);
            String oldValue = configChange.getOldValue();
            String newValue = configChange.getNewValue();
            log.info("apollo动态刷新配置【changedKey={},oldValue={}, newValue={}】", changedKey, oldValue, newValue);
        }
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changeEvent.changedKeys()));
        refreshScope.refreshAll();
    }

    /**
     * 动态刷新日志级别
     *
     * @param changeEvent
     * @return void
     * @author huangyongpeng@matrixelements.com
     * @date 2021/4/11
     */
    private void refreshLoggingLevels(ConfigChangeEvent changeEvent) {
        for (String changedKey : changeEvent.changedKeys()) {
            ConfigChange configChange = changeEvent.getChange(changedKey);
            String oldValue = configChange.getOldValue();
            String newValue = configChange.getNewValue();
            if (changedKey.startsWith(CommonConstant.LOGGING_LEVEL)) {
                String strLevel = StrUtil.emptyToDefault(newValue, LogLevel.INFO.name());
                LogLevel level = LogLevel.valueOf(strLevel.toUpperCase());
                loggingSystem.setLogLevel(changedKey, level);
            }
            log.info("apollo动态刷新日志级别配置【changedKey={},oldValue={}, newValue={}】", changedKey, oldValue, newValue);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
