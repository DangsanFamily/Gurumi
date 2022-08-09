package io.gurumi.core.blocks.domain;

import io.gurumi.core.letters.domain.Letter;

import javax.persistence.*;

@Entity
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String content;

    private String originFileName;

    private String fullPath;


    @ManyToOne(fetch=FetchType.LAZY)
    private Letter letter;

    protected Block(){
    }

    public Block(String type, String content, String originFileName, String fullPath){
        this.type = type;
        this.content = content;
        this.originFileName = originFileName;
        this.fullPath = fullPath;
    }

    public void update(Block other){
        this.content = other.content;
    }

    public Long getId(){
        return this.id;
    }

    public String getType(){
        return this.type;
    }

    public String getContent(){
        return this.content;
    }

    public String getOriginFileName() {return this.originFileName;}

    public String getFullPath(){return this.fullPath;}
}
