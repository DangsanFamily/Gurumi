package io.gurumi.core.image.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    String uploadImage(MultipartFile file) throws IOException;

    String makeUrlImage(String name);
    void deleteImage();


}
