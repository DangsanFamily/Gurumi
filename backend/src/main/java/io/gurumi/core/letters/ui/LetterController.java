package io.gurumi.core.letters.ui;

import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import io.gurumi.core.letters.ui.dto.LetterResponse;
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

    @PostMapping
    public ResponseEntity<LetterResponse> createLetter(@RequestBody BlockRequest blockRequest) {

        Long letterId = 1L;
        List<BlockResponse> blocks = Arrays.asList(
            new BlockResponse("자니...?"),
            new BlockResponse("자는구나...")
        );
        LetterResponse response = new LetterResponse(letterId, blocks);
        return ResponseEntity.ok().body(response);
    }
}
