package io.oniasfilho.todoapi.dto;

public record RegisterRequest(
    String firstname,
    String lastname,
    String email,
    String password
) {
}
