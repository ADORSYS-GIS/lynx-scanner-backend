package com.ssegning.lynx.mongo;

import com.ssegning.lynx.lynxbackend.LynxBackendApplication;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.aot.DisabledInAotMode;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@DisabledInAotMode
@IfProfileValue(name = "spring.profiles.active", value = "mongo")
@SpringBootTest(classes = LynxBackendApplication.class)
public class GridFsConfigurationIntegrationTest {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Test
    public void testGridFsTemplate() {
        assertNotNull(gridFsTemplate);
    }
}