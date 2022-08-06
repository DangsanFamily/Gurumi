package io.gurumi.core.blocks.ui;

import io.gurumi.core.blocks.service.BlockService;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import java.net.URI;

import io.gurumi.core.image.service.LocalImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/blocks")
public class BlockController {


    @Value("${user.home}")
    private String filename;
    private final BlockService blockService;

    private final LocalImageService localImageService;

    public BlockController(BlockService blockService, LocalImageService localImageService) {
        this.blockService = blockService;
        this.localImageService = localImageService;
    }



    @GetMapping("/{id}")
    public ResponseEntity<BlockResponse> readBlock(@PathVariable Long id) {
        BlockResponse blockResponse = blockService.readBlock(id);
        return ResponseEntity.ok(blockResponse);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlockResponse> createBlock(@RequestBody BlockRequest blockRequest) {
        System.out.println(filename);
        URI location = URI.create("abcd");
        BlockResponse blockResponse = blockService.createBlock(blockRequest);
        return ResponseEntity.created(location).body(blockResponse);
    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BlockResponse> createBlockForImage(BlockRequest blockRequest,
                                                     @RequestParam(required = false)MultipartFile image) {
        String fileName=localImageService.uploadImage(image);
        URI location = URI.create("abcd");
        BlockResponse blockResponse = blockService.createBlockForImage(blockRequest,fileName);
        return ResponseEntity.created(location).body(blockResponse);
    }

    @PatchMapping("/{id}")
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
