package io.gurumi.core.letters.service;


import io.gurumi.core.letters.domain.Letter;
import io.gurumi.core.letters.domain.LetterRepository;
import io.gurumi.core.letters.ui.dto.LetterRequest;
import io.gurumi.core.letters.ui.dto.LetterResponse;
import org.springframework.stereotype.Service;


@Service
public class LetterService {

    private final LetterRepository letterRepository;

    public LetterService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    public LetterResponse createLetter(LetterRequest letterRequest) {
        Letter letter = letterRequest.toEntity();
        letterRepository.save(letter);
        return letter.toResponse();

    }
}
