package io.gurumi.core.blocks.ui;

import io.gurumi.core.blocks.service.BlockService;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import io.gurumi.core.image.service.LocalImageService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
        URI location = URI.create("abcd");
        BlockResponse blockResponse = blockService.createBlock(blockRequest);
        return ResponseEntity.created(location).body(blockResponse);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BlockResponse> createBlockForImage(BlockRequest blockRequest,
                                                             @RequestParam(required = false) MultipartFile image) {
        String fileName = localImageService.uploadImage(image);
        URI location = URI.create("abcd");
        BlockResponse blockResponse = blockService.createBlockForImage(blockRequest, fileName);
        return ResponseEntity.created(location).body(blockResponse);
    }

    @PatchMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlockResponse> updateBlock(@PathVariable Long id, @RequestBody BlockRequest blockRequest) {
        BlockResponse blockResponse = blockService.updateBlock(id, blockRequest);
        return ResponseEntity.ok(blockResponse);
    }

    @PatchMapping(path = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BlockResponse> updateBlockForImage(@PathVariable Long id,
                                                             BlockRequest blockRequest,
                                                             @RequestParam(required = false) MultipartFile image) {
        String fileName = localImageService.uploadImage(image);
        BlockResponse blockResponse = blockService.updateBlockForImage(id, blockRequest, fileName);
        return ResponseEntity.ok(blockResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlock(@PathVariable Long id) {
        blockService.deleteBlock(id);
        return ResponseEntity.noContent().build();
    }
}
