package com.ssegning.lynx.lynxbackend.configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProfileConfigurations {

    @Configuration
    @ComponentScan(basePackages = "com.ssegning.lynx.local")
    @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "local")
    public static class LocalConfig {

        @PostConstruct
        public void onLoad() {
            log.info("LocalConfig loaded");
        }
    }

    @Configuration
    @ComponentScan(basePackages = "com.ssegning.lynx.mongo")
    @ConditionalOnProperty(name = "spring.profiles.active", havingValue = "mongo")
    public static class MongoConfig {

        @PostConstruct
        public void onLoad() {
            log.info("MongoConfig loaded");
        }
    }
}
