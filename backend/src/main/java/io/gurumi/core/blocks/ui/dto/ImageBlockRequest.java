package io.gurumi.core.blocks.ui.dto;

import io.gurumi.core.blocks.domain.Block;

public class ImageBlockRequest {

    private final String type;

    public ImageBlockRequest(String type) {
        this.type = type;
    }

    public Block toEntity(String imageUrl) {
        return new Block(this.type, imageUrl);
    }
}
