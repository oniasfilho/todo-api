package io.oniasfilho.todoapi.security.controller;

import io.oniasfilho.todoapi.dto.AuthenticationRequest;
import io.oniasfilho.todoapi.dto.AuthenticationResponse;
import io.oniasfilho.todoapi.dto.RegisterRequest;
import io.oniasfilho.todoapi.security.config.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(this.service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(this.service.authenticate(request));
    }
}
