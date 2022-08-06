package io.gurumi.core.blocks.ui.dto;

import io.gurumi.core.blocks.domain.Block;

public class BlockRequest {

    private String type;
    private String content;

    protected BlockRequest() {}

    private BlockRequest(String type, String content) {
        this.type = type;
        this.content = content;
    }

    public static BlockRequest of(String type, String content) {
        return new BlockRequest(type, content);
    }

    public Block toEntity() {
        return new Block(this.type, this.content);
    }

    public Block toImageEntity(String url) {
        return new Block(this.type, url);
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
