package io.gurumi.core.image.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String uploadImage(MultipartFile image);

    byte[] readImage(String imageName);
}
