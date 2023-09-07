package io.oniasfilho.todoapi.security.config;

import io.oniasfilho.todoapi.dto.AuthenticationRequest;
import io.oniasfilho.todoapi.dto.AuthenticationResponse;
import io.oniasfilho.todoapi.dto.RegisterRequest;
import io.oniasfilho.todoapi.model.User;
import io.oniasfilho.todoapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.firstname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();
        repository.save(user);
        return new AuthenticationResponse(jwtService.generateToken(user));
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var user = repository.findByEmail(request.email())
                .orElseThrow();
        return new AuthenticationResponse(jwtService.generateToken(user));
    }
}
