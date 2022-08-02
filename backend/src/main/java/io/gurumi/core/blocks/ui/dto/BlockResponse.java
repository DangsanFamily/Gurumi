package io.gurumi.core.blocks.ui.dto;

public class BlockResponse {


    private Long id;
    private String type;
    private String content;

    public BlockResponse(Long id,String type,String content) {
        this.id=id;
        this.type=type;
        this.content = content;
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
