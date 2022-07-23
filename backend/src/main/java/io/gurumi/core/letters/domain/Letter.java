package io.gurumi.core.letters.domain;

import io.gurumi.core.blocks.domain.Block;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    protected Letter() {
    }
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Block> blocks=new ArrayList<>();

    public Letter(Long id) {
        this.id = id;
    }

    public Letter(ArrayList<Block> blocks){
        this.blocks=blocks;
    }

    public Long getId() {
        return id;
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
