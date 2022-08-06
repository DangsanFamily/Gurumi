package io.gurumi.core.image.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String uploadImage(MultipartFile image);
    void deleteImage(String imageName);

}
