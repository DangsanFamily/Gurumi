package io.gurumi.core.blocks.service;

import io.gurumi.core.blocks.ui.dto.UrlInfoResponse;
import java.net.URI;
import java.net.URISyntaxException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class OpenGraphService {

    private String getDomainName(String url) throws URISyntaxException {
        URI uri = new URI(url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    public UrlInfoResponse getHtml(String targetUrl) {
        try {
            if (!targetUrl.startsWith("http") && !targetUrl.startsWith("https")) {
                targetUrl = "http://" + targetUrl;
            }
            Document document = Jsoup.connect(targetUrl).get();
            Element meta_title = document.select("meta[property=og:title]").first();
            Element meta_description = document.select("meta[property=og:description]").first();
            Element meta_image_url = document.select("meta[property=og:image]").first();

            String title = meta_title.attr("content");
            String imageUrl = meta_image_url.attr("content");
            String description = meta_description.attr("content");
            String domainName = getDomainName(targetUrl);

            return new UrlInfoResponse(title, description, imageUrl, domainName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new UrlInfoResponse(null, null, null, null);
    }
}
