package com.app.backend.configs;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class UploadConfig {
    @Value("${file.upload_dir}")
    private String uploadDirection;

    @PostConstruct
    public void init(){
        File directory=new File(uploadDirection);
        if(!directory.exists()){
            directory.mkdirs();
        }
    }
}
