package com.kh.login.dto.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadUrlResponseDto {
    private String change_name;
    private String presigned_url;
}

// 파일을 s3에 업로드(db에 정보저장)
// 업로드를 위한 preURL 요청 -> 파일업로드 -> 메타데이터를 DB 저장
