package com.example.pytorch.mp4.service;

import com.example.pytorch.mp4.dto.FileDto;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class Mp4Service {
    @Value("${mp4.path}")
    private String mp4Path;

//    public InputStreamResource download(FileDto dto) throws IOException {
//        Path path = Paths.get(mp4Path + dto.getFilePath());
//        String contentType = Files.probeContentType(path);
//
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentDisposition(
//                ContentDisposition.builder("attatchment")
//                        .filename(dto.getFilename(), StandardCharsets.UTF_8)
//                        .build()
//        );
//
//        ResponseEntity.ok()
//                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + )
//
//        httpHeaders.add(HttpHeaders.CONTENT_TYPE, contentType);
//        return InputStreamResource(Files.newInputStream(path));
//
//    }


    public List<FileDto> upload(MultipartFile[] uploadFiles) {
        List<FileDto> files = new ArrayList<>();

        Arrays.stream(uploadFiles).forEach(multipartFile -> {
            FileDto file = new FileDto(multipartFile.getOriginalFilename(), multipartFile.getContentType());
            files.add(file);

            File newFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            try {
                multipartFile.transferTo(newFile);
            }
            catch (IOException exception) {
                exception.printStackTrace();
            }
        });

        return files;
    }
}
