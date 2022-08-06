package io.gurumi.core.blocks.domain;

import io.gurumi.core.blocks.ui.dto.BlockResponse;
import io.gurumi.core.image.domain.PostImage;
import io.gurumi.core.letters.domain.Letter;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;


    @ManyToOne(fetch=FetchType.LAZY)
    private Letter letter;

    protected Block() {
    }

    public Block(Long id, String message, Letter letter) {
        this.id = id;
        this.message = message;
        this.letter = letter;
    }

    public Block(String message) {
        this.message = message;
    }

    public BlockResponse toResponse(){
        return new BlockResponse(message);
    }

    //@OneToMany(mappedBy = "post", orphanRemoval = true)
    private PostImage postImages;

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Letter getLetter() {
        return letter;
    }
}
