package com.ssegning.lynx.local.mapper;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidMapper {
    public String map(UUID value) {
        if (value == null) {
            return null;
        }

        return value.toString();
    }

    public UUID map(String value) {
        if (value == null) {
            return null;
        }

        return UUID.fromString(value);
    }
}
