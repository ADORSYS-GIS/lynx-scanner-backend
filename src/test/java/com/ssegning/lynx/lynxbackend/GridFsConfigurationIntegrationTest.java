package com.ssegning.lynx.lynxbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GridFsConfigurationIntegrationTest {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Test
    public void testGridFsTemplate() {
        assertNotNull(gridFsTemplate);
    }
}