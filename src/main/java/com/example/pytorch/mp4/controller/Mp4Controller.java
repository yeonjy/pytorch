package com.example.pytorch.mp4.controller;

import com.example.pytorch.mp4.dto.FileDto;
import com.example.pytorch.mp4.service.Mp4Service;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class Mp4Controller {

    private final Mp4Service mp4Service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/upload")
    public void upload(@RequestParam("uploadfile") MultipartFile[] uploadFiles, Model model) {
        List<FileDto> files = mp4Service.upload(uploadFiles);

        model.addAttribute("files", files);  //노쓸모
    }


//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/download")
//    public ResponseEntity<InputStreamResource> download(@ModelAttribute FileDto dto) throws IOException {
//        return mp4Service.download(dto);
//    }
}
