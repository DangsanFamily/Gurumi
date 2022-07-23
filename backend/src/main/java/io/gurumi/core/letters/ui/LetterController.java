package io.gurumi.core.letters.ui;

import io.gurumi.core.blocks.domain.Block;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import io.gurumi.core.letters.domain.Letter;
import io.gurumi.core.letters.service.LetterService;
import io.gurumi.core.letters.ui.dto.LetterRequest;
import io.gurumi.core.letters.ui.dto.LetterResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/letters")
public class LetterController {

    private final LetterService letterService;

    public LetterController(LetterService letterService) {
        this.letterService = letterService;
    }

    @PostMapping
    public ResponseEntity<LetterResponse> createLetter(@RequestBody LetterRequest letterRequest) {

        Letter letter=letterService.makeLetter(letterRequest);
        ArrayList<BlockResponse> blocks=new ArrayList<>();
        for (Block block : letter.getBlocks()) {
            blocks.add(new BlockResponse(block.getMessage()));
        }

        LetterResponse response=new LetterResponse(letter.getId(),blocks);
//        Long letterId = 1L;
//        List<BlockResponse> blocks = Arrays.asList(
//            new BlockResponse("자니...?"),
//            new BlockResponse("자는구나...")
//        );
//        LetterResponse response = new LetterResponse(letterId, blocks);


        return ResponseEntity.ok().body(response);
    }
}
