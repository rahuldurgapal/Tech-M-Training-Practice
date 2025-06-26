package com.example.SpringBootFileUpload.service;

import com.example.SpringBootFileUpload.model.FileEntity;
import com.example.SpringBootFileUpload.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;
   private String uploadDir = System.getProperty("user.dir") + "/target/classes/static/uploads";


    public void saveFile(MultipartFile file) throws IOException {
        File dir = new File(uploadDir);
        if(!dir.exists()) {
            System.out.println("Directory not found");
            if(dir.mkdirs())
              System.out.println("Directory created");
        }

        String path = uploadDir + File.separator + file.getOriginalFilename();
        file.transferTo(new File(path));


        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileName(file.getOriginalFilename());
        fileEntity.setFilePath("/uploads/" + file.getOriginalFilename());
        fileEntity.setUploadTime(LocalDateTime.now().toString());

        fileRepository.save(fileEntity);
    }

    public List<FileEntity> getAllFiles() {
        return fileRepository.findAll();
    }

}
