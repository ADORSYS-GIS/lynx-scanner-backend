package com.ssegning.lynx.lynxbackend;

import com.ssegning.lynx.lynxbackend.utils.StartFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.UnknownHostException;

@SpringBootApplication
public class LynxBackendApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(LynxBackendApplication.class);
        var env = app.run(args).getEnvironment();
        StartFormatter.printAppInfo(env);
    }

}
