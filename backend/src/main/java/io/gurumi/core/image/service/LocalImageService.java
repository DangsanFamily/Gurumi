package io.gurumi.core.image.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class LocalImageService implements ImageService {

    @Value("${upload-path}")
    private String uploadPath;
    @Override
    public String uploadImage(MultipartFile image) {
        String fileName=UUID.randomUUID()+image.getOriginalFilename();
        String pathName=uploadPath+File.separator+fileName;
        try{
            File uploadImage=new File(pathName);
            if(!uploadImage.exists()) {
                uploadImage.mkdirs();
            }
            image.transferTo(uploadImage);
            return fileName;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "";

    }

    @Override
    public void deleteImage(String imageName) {

    }
}
