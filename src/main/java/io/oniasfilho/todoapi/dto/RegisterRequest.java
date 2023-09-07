package io.oniasfilho.todoapi.dto;

import io.oniasfilho.todoapi.model.Role;

public record RegisterRequest(
    String firstname,
    String lastname,
    String email,
    String password,
    Role role
) {
}
