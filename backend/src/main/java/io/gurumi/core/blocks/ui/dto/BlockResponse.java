package io.gurumi.core.blocks.ui.dto;

import io.gurumi.core.blocks.domain.Block;

public class BlockResponse {

    private final Long id;
    private final String type;
    private final String content;
    private final String originFileName;
    private final String fullPath;

    private BlockResponse(Long id, String type, String content, String originFileName, String fullPath){
        this.id = id;
        this.type = type;
        this.content = content;
        this.originFileName = originFileName;
        this.fullPath = fullPath;
    }

    public static BlockResponse of(Block block){
        return new BlockResponse(
            block.getId(),
            block.getType(),
            block.getContent(),
            block.getOriginFileName(),
            block.getFullPath()
        );
    }

    public Long getId() {
        return id;
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
