package io.gurumi.core.image.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
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
