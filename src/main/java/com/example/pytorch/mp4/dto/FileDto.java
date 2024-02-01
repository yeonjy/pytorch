package com.example.pytorch.mp4.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
    private String filename;
    private String contentType;
}
