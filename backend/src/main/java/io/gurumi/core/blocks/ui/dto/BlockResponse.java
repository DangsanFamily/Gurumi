package io.gurumi.core.blocks.ui.dto;

import io.gurumi.core.blocks.domain.Block;

public class BlockResponse {


    private Long id;
    private String type;
    private String content;

    protected BlockResponse() {}

    private BlockResponse(Long id, String type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    public static BlockResponse of(Block block) {
        return new BlockResponse(
            block.getId(),
            block.getType(),
            block.getContent()
        );
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
