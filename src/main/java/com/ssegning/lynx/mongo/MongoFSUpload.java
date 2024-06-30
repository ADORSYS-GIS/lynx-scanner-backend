package com.ssegning.lynx.mongo;

import com.ssegning.lynx.lynxbackend.exceptions.StorageFileNotFoundException;
import com.ssegning.lynx.lynxbackend.service.FileUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.gridfs.GridFsCriteria.whereFilename;
import static org.springframework.data.mongodb.gridfs.GridFsCriteria.where;

@Service
@RequiredArgsConstructor
public class MongoFSUpload implements FileUpload {

    private final GridFsTemplate gridFsTemplate;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        var fileName = file.getOriginalFilename();
        var fileId = gridFsTemplate.store(file.getInputStream(), fileName, file.getContentType());
        return fileId.toHexString();
    }

    @Override
    public Resource downloadFile(String fileId) {
        var file = gridFsTemplate.findOne(query(where("_id").is(fileId)));
        if (file == null) {
            throw new StorageFileNotFoundException("File not found");
        }

        return gridFsTemplate.getResource(file);
    }

    @Override
    public void deleteFile(String fileName) {
        gridFsTemplate.delete(query(whereFilename().is(fileName)));
    }
}
