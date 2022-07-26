package io.gurumi.core.letters.domain;

import io.gurumi.core.blocks.domain.Block;
import io.gurumi.core.blocks.ui.dto.BlockRequest;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import io.gurumi.core.letters.ui.dto.LetterResponse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected Letter() {
    }

    @OneToMany(mappedBy = "letter",fetch=FetchType.LAZY,cascade = {CascadeType.ALL})
    private List<Block> blocks=new ArrayList<>();

    public Letter(Long id) {
        this.id = id;
    }

    public Letter(List<Block> blocks){
        this.blocks=blocks;
    }

    public LetterResponse toResponse(){
        List<BlockResponse> blockList=new ArrayList<>();
        for (Block block : blocks) {
            blockList.add(block.toResponse());
        }
        return new LetterResponse(id,blockList);
    }
    public Long getId() {
        return id;
    }

    public List<Block> getBlocks() {
        return blocks;
    }
}
