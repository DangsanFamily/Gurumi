package io.gurumi.core.image.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
@Component
public class LocalImageService implements ImageService {



    @Override
    public String uploadImage(MultipartFile image) throws IOException {

        String name = UUID.randomUUID() + image.getOriginalFilename();
        String path = "/Users/sonjiwon/Temp"+File.separator+ name;

        File uploadImage = new File(path);
        image.transferTo(uploadImage);

        return name;
    }

    public String makeUrlImage(String name){
        String domain = "http://localhost:8080";
        String path = "/image?filename="+ name;

        return domain+path;
    }

    @Override
    public void deleteImage() {
    }


}
