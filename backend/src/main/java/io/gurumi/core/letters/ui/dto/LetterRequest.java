package io.gurumi.core.letters.ui.dto;

import io.gurumi.core.blocks.domain.Block;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.letters.domain.Letter;
import java.util.ArrayList;
import java.util.List;

public class LetterRequest {

    private List<BlockRequest> blocks;

    public LetterRequest() {
    }

    public LetterRequest(List<BlockRequest> blocks) {
        this.blocks = blocks;
    }

    public List<BlockRequest> getBlocks() {
        return blocks;
    }

    public Letter toEntity() {

        List<Block> blockList = new ArrayList<>();
        for (BlockRequest block : blocks) {
            blockList.add(block.toEntity());
        }
        return new Letter(blockList);

    }
}
