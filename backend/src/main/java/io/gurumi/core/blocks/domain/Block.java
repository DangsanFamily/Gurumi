package io.gurumi.core.blocks.domain;

import io.gurumi.core.letters.domain.Letter;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;
    @ManyToOne(cascade = CascadeType.ALL)
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
