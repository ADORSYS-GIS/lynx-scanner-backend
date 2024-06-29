package com.ssegning.lynx.mongo;

import com.ssegning.lynx.lynxbackend.LynxBackendApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "mongo")
@TestConfiguration(proxyBeanMethods = false)
public class TestLynxBackendApplication {

	@Bean
	@ServiceConnection
	MongoDBContainer mongoDbContainer() {
		return new MongoDBContainer(DockerImageName.parse("mongo:latest"));
	}

	public static void main(String[] args) {
		SpringApplication.from(LynxBackendApplication::main).with(TestLynxBackendApplication.class).run(args);
	}

}
