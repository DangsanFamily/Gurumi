package io.gurumi.core.blocks.service;

import io.gurumi.core.blocks.domain.Block;
import io.gurumi.core.blocks.domain.BlockRepository;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlockService {

    private final BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Transactional(readOnly = true)
    public BlockResponse readBlock(Long blockId) {
        Block block = blockRepository.findById(blockId)
            .orElseThrow(IllegalArgumentException::new);
        return BlockResponse.of(block);
    }

    public BlockResponse createBlock(BlockRequest blockRequest) {
        Block block = blockRequest.toEntity();
        blockRepository.save(block);
        return BlockResponse.of(block);
    }

    public BlockResponse updateBlock(Long blockId, BlockRequest blockRequest) {
        Block block = blockRepository.findById(blockId)
                .orElseThrow(IllegalArgumentException::new);
        Block other = blockRequest.toEntity();
        block.update(other);
        return BlockResponse.of(block);
    }

    public void deleteBlock(Long blockId) {
        blockRepository.deleteById(blockId);
    }
}
