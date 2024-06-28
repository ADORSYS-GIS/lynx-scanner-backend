package com.ssegning.lynx.lynxbackend.utils;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@ToString
public class StartFormatter {

    public static void printAppInfo(Environment env) throws UnknownHostException {
        String protocol = "http";
        final var serverSslEnabled = env.getProperty("server.ssl.enabled");
        if (env.getProperty("server.ssl.key-store") != null
                && serverSslEnabled != null
                && serverSslEnabled.equals("true")) {
            protocol = "https";
        }

        var contextPath = env.getProperty("server.servlet.context-path");
        contextPath = contextPath == null ? "/" : contextPath;

        final var serverPort = env.getProperty("server.port");

        log.info("""
                        
                        ----------------------------------------------------------
                        Application '{}' is running! Access URLs:\t
                        Local: \t\t\t{}://localhost:{}{}\t
                        External: \t\t{}://{}:{}{}\t
                        Profile(s): \t{}
                        ----------------------------------------------------------
                        """,
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                serverPort,
                contextPath,
                env.getActiveProfiles());
    }

}

