package com.ssegning.lynx.local.service;

import com.ssegning.lynx.lynxbackend.exceptions.StorageException;
import com.ssegning.lynx.lynxbackend.exceptions.StorageFileNotFoundException;
import com.ssegning.lynx.lynxbackend.service.FileUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LocalFSUploadService implements FileUpload {

    @Value("${file.upload-dir}")
    private Path rootLocation;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        final var fileNameCleaned = Objects.requireNonNull(file.getOriginalFilename()).replaceAll("\\s", "_");
        final var randomName = "file_%s_%s".formatted(System.currentTimeMillis(), fileNameCleaned);

        if (file.isEmpty()) {
            throw new StorageException("Failed to store empty file.");
        }

        var destinationFile = this.rootLocation
                .resolve(Paths.get(randomName))
                .normalize()
                .toAbsolutePath();

        if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
            throw new StorageException("Cannot store file outside current directory.");
        }

        // Parent should be created before writing the file
        Files.createDirectories(destinationFile.getParent());

        try (final var inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        }

        return randomName;
    }

    @Override
    public Resource downloadFile(String fileName) {
        try {
            var file = rootLocation.resolve(fileName);
            var resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException("Could not read file: " + fileName);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + fileName, e);
        }
    }

    @Override
    public void deleteFile(String fileName) {
        var file = rootLocation.resolve(fileName);
        FileSystemUtils.deleteRecursively(file.toFile());
    }
}
