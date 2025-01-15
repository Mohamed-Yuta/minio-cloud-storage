package com.allali.minIO.dto;

import lombok.Data;

@Data
public class FileDTO {
    private String filename;
    private String uploadDate;
    private String size;
    private String url;
}
