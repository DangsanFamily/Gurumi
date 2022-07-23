package io.gurumi.core.letters.service;

import io.gurumi.core.blocks.domain.Block;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.letters.domain.Letter;
import io.gurumi.core.letters.domain.LetterRepository;
import io.gurumi.core.letters.ui.dto.LetterRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LetterService {

    private final LetterRepository letterRepository;

    public LetterService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    public Letter makeLetter(LetterRequest letterRequest){
        ArrayList<Block> blocks=new ArrayList<>();
        for (BlockRequest block : letterRequest.getBlocks()) {
            blocks.add(new Block(block.getMessage()));
        }
        Letter letter=new Letter(blocks);

        return letterRepository.save(letter);
    }
}
