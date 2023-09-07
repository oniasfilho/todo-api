package io.oniasfilho.todoapi.dto;

public record AuthenticationRequest(
    String email,
    String password
) {
}
