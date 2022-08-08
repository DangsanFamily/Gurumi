package io.gurumi.core.blocks.ui;

import io.gurumi.core.blocks.service.OpenGraphService;
import io.gurumi.core.blocks.ui.dto.UrlInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/link")
public class UrlInfoController {

    private final OpenGraphService openGraphService;

    public UrlInfoController(OpenGraphService openGraphService) {
        this.openGraphService = openGraphService;
    }

    @GetMapping()
    public ResponseEntity<UrlInfoResponse> getOpenGraph(@RequestParam String url) {
        UrlInfoResponse body = openGraphService.getHtml(url);
        return ResponseEntity.ok(body);
    }
}
