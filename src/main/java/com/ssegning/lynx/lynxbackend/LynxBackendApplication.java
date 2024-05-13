package com.ssegning.lynx.lynxbackend;

import com.ssegning.lynx.lynxbackend.Controller.Controller;
import com.ssegning.lynx.lynxbackend.configuration.GridFsConfiguration;
import com.ssegning.lynx.lynxbackend.configuration.JwtConverter;
import com.ssegning.lynx.lynxbackend.configuration.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SecurityConfig.class, JwtConverter.class, Controller.class, GridFsConfiguration.class}) // Explicitly import SecurityConfig and JwtConverter
public class LynxBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LynxBackendApplication.class, args);
	}

}

