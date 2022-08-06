package io.gurumi.core.image.domain;

import io.gurumi.core.blocks.domain.Block;

import javax.persistence.*;

@Entity

public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String storeFilename;

   // @Embedded
   // private TimeEntity timeEntity;

    @JoinColumn(name="post_id")
    private Block block;

    public PostImage(String imageUrl, String storeFilename, Block block) {
        this.imageUrl = imageUrl;
        this.storeFilename = storeFilename;
        this.block = block;
    }

   // @Override
   // public void setTimeEntity(TimeEntity timeEntity) {
   //     this.imageUrl = imageUrl;
   //     this.storeFilename = storeFilename;
   //     this.block = block;
   // }


    protected PostImage() {
    }

   // @Override
   // public void setTimeEntity(TimeEntity timeEntity) {
   //     this.timeEntity = timeEntity;
   // }

}
