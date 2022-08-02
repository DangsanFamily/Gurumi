package io.gurumi.core.letters.domain;

import io.gurumi.core.blocks.domain.Block;
import io.gurumi.core.blocks.ui.dto.BlockResponse;
import io.gurumi.core.letters.ui.dto.LetterResponse;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
            blockList.add(BlockResponse.of(block));
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
