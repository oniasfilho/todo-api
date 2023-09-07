package io.oniasfilho.todoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class SecureController {
    @GetMapping("/ping")
    public String ping() {
        return "protected pong";
    }
}
