package io.gurumi.core.blocks.domain;

import io.gurumi.core.letters.domain.Letter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String content;
    @ManyToOne(fetch=FetchType.LAZY)
    private Letter letter;

    protected Block() {
    }

    public Block(String type,String content) {
        this.type=type;
        this.content = content;
    }

    public void update(Block other) {
        this.content = other.content;
    }

    public Long getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public String getContent() {
        return content;
    }
}
