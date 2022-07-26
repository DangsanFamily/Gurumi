package io.gurumi.core.blocks.ui.dto;

import io.gurumi.core.blocks.domain.Block;

public class BlockRequest {

    private String message;

    public BlockRequest() {
    }

    public BlockRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public Block toEntity(){
        return new Block(message);
    }
}
