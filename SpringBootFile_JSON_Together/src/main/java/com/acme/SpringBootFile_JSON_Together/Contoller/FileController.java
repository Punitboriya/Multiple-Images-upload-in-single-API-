package com.acme.SpringBootFile_JSON_Together.Contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@RestController
public class FileController {

    private Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/upload-files")
    public ResponseEntity<?> uploadMultipleFiles(
            @RequestParam("images") MultipartFile[] files) {
        this.logger.info("{} no. of files uploaded ", files.length);
        Arrays.stream(files).forEach(m -> {
            logger.info("File Name:{}", m.getOriginalFilename());
            logger.info("File Type:{}", m.getContentType());
            System.out.println("------------------");
        });
        return ResponseEntity.ok("Files Uploded");


    }


}