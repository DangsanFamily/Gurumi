package io.gurumi.core.blocks.ui;

import io.gurumi.core.blocks.service.BlockService;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blocks")
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService){
        this.blockService=blockService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlockResponse> readBlock(@PathVariable(name="id") Long blockId){
        return ResponseEntity.status(HttpStatus.OK).body(blockService.readBlock(blockId));
    }
    @PostMapping
    public ResponseEntity<BlockResponse> createBlock(@RequestBody BlockRequest blockRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(blockService.createBlock(blockRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BlockResponse> updateBlock(@RequestBody BlockRequest blockRequest,@PathVariable(name="id") Long blockId){
        return ResponseEntity.status(HttpStatus.OK).body(blockService.updateBlock(blockRequest,blockId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlock(@PathVariable(name="id") Long blockId){
        blockService.deleteBlock(blockId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
