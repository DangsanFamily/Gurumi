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

    //private TimeEntity timeEntity;

    /*@OneToMany(mappedBy ="post", orphanRemoval = true)
    private List<PostImage> postImages = new ArrayList<>();*/

    @ManyToOne(fetch=FetchType.LAZY)
    private Letter letter;

    protected Block(){
    }

    public Block(String type, String content){
        this.type = type;
        this.content = content;
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

    /*@Override
    public void setTimeEntity(TimeEntity timeEntity){
        this.timeEntity = timeEntity;
    }*/



}
