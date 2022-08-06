package io.gurumi.core.image.controller;


import io.gurumi.core.image.service.ImageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping(value = "/{fileName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable String fileName) {
        return imageService.readImage(fileName);
    }
}
