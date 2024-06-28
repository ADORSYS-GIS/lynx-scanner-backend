package com.ssegning.lynx.lynxbackend.service;

import com.ssegning.lynx.lynxbackend.exceptions.StorageFileNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.gridfs.GridFsCriteria.whereFilename;

@Service
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "mongo")
@RequiredArgsConstructor
public class MongoFSUpload implements FileUpload {

    private final GridFsTemplate gridFsTemplate;

    @Override
    public void uploadFile(String fileName, MultipartFile file) throws IOException {
        gridFsTemplate.store(file.getInputStream(), fileName, file.getContentType());
    }

    @Override
    public Resource downloadFile(String fileName) {
        var one = gridFsTemplate.findOne(query(whereFilename().is(fileName)));
        if (one == null) {
            throw new StorageFileNotFoundException("Could not read file: " + fileName);
        }

        return gridFsTemplate.getResource(one);
    }

    @Override
    public void deleteFile(String fileName) {
        gridFsTemplate.delete(query(whereFilename().is(fileName)));
    }
}
