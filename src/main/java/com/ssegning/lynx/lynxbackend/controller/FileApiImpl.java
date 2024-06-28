package com.ssegning.lynx.lynxbackend.controller;

import com.ssegning.lynx.lynxbackend.api.FileApi;
import com.ssegning.lynx.lynxbackend.model.FileUploadResponse;
import com.ssegning.lynx.lynxbackend.service.FileUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FileApiImpl implements FileApi {
    private final FileUpload fileUpload;

    @Override
    public Resource getFile(String fileId) {
        return fileUpload.downloadFile(fileId);
    }

    // TODO
    @Override
    public FileUploadResponse uploadFile(MultipartFile file) {
        return FileApi.super.uploadFile(file);
    }
}
