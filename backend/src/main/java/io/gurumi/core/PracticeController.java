package io.gurumi.core;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class PracticeController {

    @GetMapping
    public String helloSpring(){
        return "Hello Spring!";
    }
}
