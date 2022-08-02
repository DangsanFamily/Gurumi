package io.gurumi.core.blocks.ui.dto;

import io.gurumi.core.blocks.domain.Block;

public class BlockRequest {

    private String type;

    private String content;



    public BlockRequest() {
    }

    public BlockRequest(String type,String content) {
        this.type=type;
        this.content = content;

    }


    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public Block toEntity(){
        return new Block(this.type,this.content);
    }


}
