package io.gurumi.core.letters.ui;

import io.gurumi.core.letters.service.LetterService;
import io.gurumi.core.letters.ui.dto.LetterRequest;
import io.gurumi.core.letters.ui.dto.LetterResponse;
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
        LetterResponse response = letterService.createLetter(letterRequest);
        return ResponseEntity.ok().body(response);
    }
}
