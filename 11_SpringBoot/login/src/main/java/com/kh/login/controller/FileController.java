package com.kh.login.controller;

import com.kh.login.domain.File;
import com.kh.login.dto.file.CompleteUploadRequestDto;
import com.kh.login.dto.file.UploadUrlResponseDto;
import com.kh.login.service.FileService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<UploadUrlResponseDto> getUploadUrl(@RequestParam String fileName,
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

        return ResponseEntity.ok(new UploadUrlResponseDto(changeName, presignedUrl));
    }

    @PostMapping("/complete")
    public ResponseEntity<File> completeUpload(@RequestBody CompleteUploadRequestDto request){
        File file = fileService.saveFileInfo(request.getOriginal_name(), request.getChange_name(), request.getContent_type());
        return ResponseEntity.ok(file);
    }

    @GetMapping
    public ResponseEntity<List<File>> getFiles() {
        return ResponseEntity.ok(fileService.getAllFiles());
    }

    @GetMapping("/{fileId}/download-url")
    public ResponseEntity<?> getDownloaddUrl(@PathVariable Long fileId){
        File file = fileService.getFile(fileId);
        String presignedUrl = fileService.generatePresignedDownloadUrl(file.getChangeName());
        return null;
    }
}
