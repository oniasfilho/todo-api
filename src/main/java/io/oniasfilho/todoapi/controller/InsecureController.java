package io.oniasfilho.todoapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unprotected")
public class InsecureController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
