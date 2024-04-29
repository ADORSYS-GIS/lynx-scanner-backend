package com.ssegning.lynx.lynxbackend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.client.MongoClient;
import com.ssegning.lynx.lynxbackend.configuration.GridFsConfiguration;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GridFsConfigurationTest {

    @Mock
    private MongoClient mockMongoClient; // Mocked MongoDB client

    
    private GridFsConfiguration gridFsConfiguration;

    @BeforeEach
    public void setup() {
        gridFsConfiguration = new GridFsConfiguration() {
            @Override
            public MongoClient mongoClient() {
                return mockMongoClient;
            }
        };
    }


    @Test
    @DisplayName("")
    public void testMongoClient() {


        // Call methods and perform assertions
        MongoClient returnedMongoClient = gridFsConfiguration.mongoClient();

        assertNotNull(returnedMongoClient);
        assertEquals(mockMongoClient, returnedMongoClient); // Verify the returned MongoClient is the same as the mocked one
    }
}
