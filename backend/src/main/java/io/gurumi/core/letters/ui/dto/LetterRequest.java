package io.gurumi.core.letters.ui.dto;

import io.gurumi.core.blocks.ui.dto.BlockRequest;
import java.util.List;

public class LetterRequest {

    private List<BlockRequest> blocks;

    public LetterRequest() {
    }

    public LetterRequest(List<BlockRequest> blocks) {
        this.blocks = blocks;
    }
}
