package com.platon.browser.cache;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

//@RefreshScope
@Slf4j
@Component
@Data
//@ConfigurationProperties(prefix = "spring.profiles")
public class TestBean {

    @Value("${spring.profiles.active}")
    private String active;

}
