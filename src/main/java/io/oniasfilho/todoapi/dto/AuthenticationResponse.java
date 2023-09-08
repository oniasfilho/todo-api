package io.oniasfilho.todoapi.dto;

public record AuthenticationResponse(String token, String refreshToken) {
}
