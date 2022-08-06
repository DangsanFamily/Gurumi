package io.gurumi.core.blocks.service;

import io.gurumi.core.blocks.domain.Block;
import io.gurumi.core.blocks.domain.BlockRepository;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import io.gurumi.core.blocks.ui.dto.ImageBlockRequest;
import io.gurumi.core.image.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class BlockService {

    @Value("${domain-name}")
    private String domainName;
    @Value("${image-path}")
    private String imagePath;

    private final ImageService imageService;
    private final BlockRepository blockRepository;

    public BlockService(ImageService imageService, BlockRepository blockRepository) {
        this.imageService = imageService;
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

    public BlockResponse createImageBlock(ImageBlockRequest imageBlockRequest, MultipartFile image) {
        String url = upload(image);
        Block block = imageBlockRequest.toEntity(url);
        blockRepository.save(block);
        return BlockResponse.of(block);
    }

    private String upload(MultipartFile image) {
        String fileName = imageService.uploadImage(image);
        return String.format("%s%s%s", domainName, imagePath, fileName);
    }

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
