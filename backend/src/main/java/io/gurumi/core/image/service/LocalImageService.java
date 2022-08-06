package io.gurumi.core.image.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.StringJoiner;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LocalImageService implements ImageService {

    @Value("${upload-path}")
    private String uploadPath;

    @Override
    public String uploadImage(MultipartFile image) {
        String fileName = String.format("%s%s", UUID.randomUUID(), image.getOriginalFilename());
        saveImageInLocal(image, fileName);
        return fileName;
    }

    private void saveImageInLocal(MultipartFile image, String fileName) {
        try {
            String pathName = new StringJoiner(File.separator).add(uploadPath).add(fileName).toString();
            File uploadImage = new File(pathName);
            uploadImage.mkdirs();
            image.transferTo(uploadImage);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public byte[] readImage(String fileName) {
        String pathName = String.format("%s%s%s", uploadPath, File.separator, fileName);
        try (InputStream in = new FileInputStream(pathName)) {
            return in.readAllBytes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
