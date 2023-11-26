package com.acme.SpringBootFile_JSON_Together.Contoller;

import com.acme.SpringBootFile_JSON_Together.Entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
public class UserContoller {

    private Logger logger = LoggerFactory.getLogger(UserContoller.class);
    @Autowired
    private ObjectMapper mapper;

    @PostMapping
    public ResponseEntity<?> addUserInformation(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userDate") String userData) {
        this.logger.info("Add User Request");
        logger.info("File Information :  {}", file.getOriginalFilename());
        logger.info("User : {}", userData);

        //converting String in to JSON object

        User user = null;
        try {
            mapper.readValue(userData, User.class);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request");
        }

//        this.logger.info("User Data is : {}", user);

        return ResponseEntity.ok(userData);
    }
}
