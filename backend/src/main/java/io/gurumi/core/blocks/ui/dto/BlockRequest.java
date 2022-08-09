package io.gurumi.core.blocks.ui.dto;

import io.gurumi.core.blocks.domain.Block;

public class BlockRequest {

    private String type;

    private String content;

    private String originFileName;

    private String fullPath;

    public Block toEntity(){
        return new Block(
                this.type, this.content, this.originFileName, this.fullPath
        );
    }


    public String getType(){
        return type;
    }
    public String getContent(){
        return content;
    }
    public String getOriginFileName() {return originFileName;}
    public String getFullPath(){return fullPath;}

}
