package io.gurumi.core.letters.ui.dto;

import io.gurumi.core.blocks.ui.dto.BlockResponse;
import java.util.List;

public class LetterResponse {

    private Long id;
    private List<BlockResponse> blocks;

    public LetterResponse() {
    }

    public LetterResponse(Long id, List<BlockResponse> blocks) {
        this.id = id;
        this.blocks = blocks;
    }

    public Long getId() {
        return id;
    }

    public List<BlockResponse> getBlocks() {
        return blocks;
    }
}
