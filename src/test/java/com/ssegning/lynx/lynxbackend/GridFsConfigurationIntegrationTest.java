package com.ssegning.lynx.lynxbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.annotation.IfProfileValue;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@IfProfileValue(name = "spring.profiles.active", value = "mongo")
@SpringBootTest
public class GridFsConfigurationIntegrationTest {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Test
    public void testGridFsTemplate() {
        assertNotNull(gridFsTemplate);
    }
}