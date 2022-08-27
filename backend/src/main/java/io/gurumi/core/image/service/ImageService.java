package io.gurumi.core.image.service;

import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public interface ImageService {

    String uploadImage(MultipartFile file) throws IOException;

    String makeUrlImage(String name);
    void deleteImage();

    //s3
//    String uploadFiles(MultipartFile file, String dirName) throws IOException;


    /*    String upload(MultipartFile file, String filePath);

    String uploadImage(MultipartFile file, String dirName) throws IOException;

    String upload(File uploadFile, String filePath);

    void removeNewFile(File removeFile);

    String putS3(File uploadFile, String fileName);


    Optional<File> convert(MultipartFile file) throws IOException;*/

}
