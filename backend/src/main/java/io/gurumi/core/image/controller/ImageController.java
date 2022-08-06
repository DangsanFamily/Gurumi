package io.gurumi.core.image.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Value("${upload-path}")
    private String filePath;

    @GetMapping(value="/{fileName}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable String fileName){
        String pathName=filePath+ File.separator+fileName;
        try{
            InputStream in = new FileInputStream(pathName);
            return in.readAllBytes();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
