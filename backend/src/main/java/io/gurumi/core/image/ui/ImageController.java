package io.gurumi.core.image.ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class ImageController {

    @Value("${upload-path}")
    String path;

    @GetMapping
    public ResponseEntity<Resource> display(@RequestParam("filename") String filename) throws IOException {

        Resource resource = new FileSystemResource(path + filename);
        HttpHeaders header = new HttpHeaders();
        Path filePath = null;

        filePath = Paths.get(path+filename);
        header.add("Content-type", Files.probeContentType(filePath));

        return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);

    }


}
