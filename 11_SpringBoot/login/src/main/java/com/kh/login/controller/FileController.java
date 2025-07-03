package com.kh.login.controller;

import com.kh.login.domain.File;
import com.kh.login.service.FileService;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/v1/files")
@RestController
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload-url")
    public String getUploadUrl(@RequestParam String fileName,
                               @RequestParam String contentType,
                               @RequestParam(required = false, defaultValue = "") String path) {

        //경로 + 변경된 이름 + 확장자

        //확장자 추출
        String extension = "";
        int lastDotIndex = fileName.lastIndexOf('.');
        if(lastDotIndex>0) {
            extension = fileName.substring(lastDotIndex);
        }

        //저장할 이름
        String changeName = path + UUID.randomUUID().toString() + extension;
        String presignedUrl = fileService.generatePresignedUploadUrl(changeName, contentType);

        return presignedUrl;
    }
}
