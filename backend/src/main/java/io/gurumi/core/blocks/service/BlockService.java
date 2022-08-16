package io.gurumi.core.blocks.service;

import io.gurumi.core.blocks.domain.Block;
import io.gurumi.core.blocks.domain.BlockRepository;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

@Service
@Transactional
public class BlockService {

    private final BlockRepository blockRepository;

    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    private Block findById(Long blockId) {
        return blockRepository.findById(blockId)
            .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional(readOnly = true)
    public BlockResponse readBlock(Long blockId) {
        Block block = findById(blockId);
        return BlockResponse.of(block);
    }

    public BlockResponse createBlock(BlockRequest blockRequest) {
        Block block = blockRequest.toEntity();
        blockRepository.save(block);
        return BlockResponse.of(block);
    }
    //이미지 업로드
    public BlockResponse createBlockForImage(BlockRequest blockRequest, String url){
        blockRequest.setContent(url);
        Block block = blockRequest.toEntity();
        blockRepository.save(block);
        return BlockResponse.of(block);
    }

//    //이미지 수정
//    public BlockResponse updateUploadImage(Long blockId, BlockRequest blockRequest, File image){
//        Block existedBlock = findById(blockId);
//        Block updatedBlock = blockRequest.toEntity();
//        return;
//    }

    public BlockResponse updateBlock(Long blockId, BlockRequest blockRequest) {
        Block existedBlock = findById(blockId);
        Block updatedBlock = blockRequest.toEntity();
        existedBlock.update(updatedBlock);
        return BlockResponse.of(existedBlock);
    }

    public void deleteBlock(Long blockId) {
        blockRepository.deleteById(blockId);
    }
}
