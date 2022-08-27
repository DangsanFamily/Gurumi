package io.gurumi.core.image.domain;

import io.gurumi.core.blocks.domain.Block;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix= "cloud.aus.c3")
@Component
public class S3Component {

    private String bucket;


    protected S3Component() {
    }

    public S3Component(String bucket) {
        this.bucket = bucket;
    }

    public String getBucket() {
        return this.bucket;
    }

    public void setBucket(String bucket){ this.bucket = bucket; }


}
