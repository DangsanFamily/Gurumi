package io.gurumi.core.image.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class ImageController {

    @Value("${upload-path}")
    private String filePath;

    @GetMapping(value = "/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable String fileName) {
        String pathName = filePath + File.separator + fileName;
        try {
            InputStream in = new FileInputStream(pathName);
            return in.readAllBytes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
