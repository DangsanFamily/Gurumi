package io.gurumi.core.blocks.ui;

import io.gurumi.core.blocks.service.BlockService;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import io.gurumi.core.blocks.ui.dto.ImageBlockRequest;
import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/blocks")
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
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
    public ResponseEntity<BlockResponse> createImageBlock(@ModelAttribute ImageBlockRequest imageBlockRequest,
                                                          @RequestParam MultipartFile image) {
        URI location = URI.create("abcd");
        BlockResponse blockResponse = blockService.createImageBlock(imageBlockRequest, image);
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
