package io.gurumi.core.image.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class LocalImageService implements ImageService {


    @Value("${upload-path}")
    private String uploadPath;
    @Value("${domain-name}")
    private String domainName;

    @Override
    public String uploadImage(MultipartFile image) throws IOException {

        String name = UUID.randomUUID() + image.getOriginalFilename();
        String path = uploadPath + File.separator + name;

        File uploadImage = new File(path);
        image.transferTo(uploadImage);

        return name;
    }

    public String makeUrlImage(String name){
        String domain = domainName;
        String path = "/image?filename="+ name; //쿼리 파라미터만됨 // path variable X

        return domain+path;
    }

    @Override
    public void deleteImage() {
    }
}
