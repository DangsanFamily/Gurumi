package io.gurumi.core.blocks.service;

import io.gurumi.core.blocks.domain.Block;
import io.gurumi.core.blocks.domain.BlockRepository;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import org.springframework.stereotype.Service;

@Service
public class BlockService {

    private final BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    public BlockResponse readBlock(Long blockId) {
        Block block = blockRepository.findById(blockId).get();
        return block.toResponse();

    }

    public BlockResponse createBlock(BlockRequest blockRequest) {
        Block block = blockRequest.toEntity();
        blockRepository.save(block);
        return block.toResponse();
    }

    public BlockResponse updateBlock(Long blockId, BlockRequest blockRequest) {
        Block block = blockRepository.findById(blockId).get();
        block.setContent(blockRequest.getContent());
        blockRepository.save(block);
        return block.toResponse();
    }

    public void deleteBlock(Long blockId) {
        blockRepository.deleteById(blockId);
    }
}
