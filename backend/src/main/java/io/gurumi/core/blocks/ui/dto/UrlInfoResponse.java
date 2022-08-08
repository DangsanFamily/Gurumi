package io.gurumi.core.blocks.ui.dto;

public class UrlInfoResponse {

    private final String title;
    private final String description;
    private final String imgUrl;
    private final String domainName;



    public UrlInfoResponse(String title, String description, String imgUrl, String domainName) {
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.domainName = domainName;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDomainName() {
        return domainName;
    }
}
