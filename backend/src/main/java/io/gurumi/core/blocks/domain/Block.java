package io.gurumi.core.blocks.domain;

import io.gurumi.core.blocks.ui.dto.BlockResponse;
import io.gurumi.core.letters.domain.Letter;

import javax.persistence.*;

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

    public Block(Long id, String type, String content, Letter letter) {
        this.id = id;
        this.type=type;
        this.content = content;
        this.letter = letter;
    }

    public Block(String type,String content) {
        this.type=type;
        this.content = content;
    }



    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public Letter getLetter() {
        return letter;
    }

    public BlockResponse toResponse(){
        return new BlockResponse(this.id,this.type,this.content);
    };

    public void setContent(String content) {
        this.content = content;
    }
}
