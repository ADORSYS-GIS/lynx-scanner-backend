package com.ssegning.lynx.local;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@Configuration
@EnableJpaRepositories
public class JpaConfig {
}
