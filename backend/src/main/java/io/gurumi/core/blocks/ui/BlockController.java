package io.gurumi.core.blocks.ui;

import io.gurumi.core.blocks.service.BlockService;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;

import java.io.IOException;
import java.net.URI;

import io.gurumi.core.image.service.AwsS3UploadService;
import io.gurumi.core.image.service.ImageService;
import io.gurumi.core.image.service.LocalImageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/blocks")
public class BlockController {

    private final ImageService imageService;
    private final BlockService blockService;

    public BlockController(AwsS3UploadService imageService, BlockService blockService) {
        this.imageService = imageService;
        this.blockService = blockService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<BlockResponse> readBlock(@PathVariable Long id) {
        BlockResponse blockResponse = blockService.readBlock(id);
        return ResponseEntity.ok(blockResponse);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BlockResponse> createBlock(@RequestBody BlockRequest blockRequest) {
        URI location = URI.create("abcd");
        BlockResponse blockResponse = blockService.createBlock(blockRequest);
        return ResponseEntity.created(location).body(blockResponse);
    }

    //이미지 업로드
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<BlockResponse> createUploadImage(BlockRequest blockRequest,
                                                           @RequestPart MultipartFile image) throws IOException {
        System.out.println(blockRequest.getType());
        System.out.println(image.getOriginalFilename());

        String url = imageService.uploadImage(image);
        // nString url = imageService.makeUrlImage(name);
        //추가
//        String s3File = imageService.uploadFiles(image,"static" );

        BlockResponse blockResponse = blockService.createBlockForImage(blockRequest, url);
        return ResponseEntity.ok(blockResponse);
    }

    //이미지 업로드 aws
    /*@PostMapping("/api/v1/upload")
    public ResponseEntity<BlockResponse> uploadImageS3(@RequestPart MultipartFile file) throws IllegalAccessException, IOException {

        System.out.println(file.getOriginalFilename());

        String image = imageService.createImageS3(file);
        BlockResponse blockResponse = imageService.createImageS3(file);

        return ResponseEntity.ok(blockResponse);
    }*/

    //이미지 수정

    @PostMapping("/{id}")
    public ResponseEntity<BlockResponse> updateBlock(@PathVariable Long id, @RequestBody BlockRequest blockRequest) {
        BlockResponse blockResponse = blockService.updateBlock(id, blockRequest);
        return ResponseEntity.ok(blockResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlock(@PathVariable Long id) {
        blockService.deleteBlock(id);
        return ResponseEntity.noContent().build();
    }
}
