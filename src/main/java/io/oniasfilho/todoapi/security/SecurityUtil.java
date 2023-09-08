package io.oniasfilho.todoapi.security;

import io.oniasfilho.todoapi.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    private SecurityUtil() {}

    public static User getLoggedUser() {
        return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static String getLoggedUserEmail() {
        var principal = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getEmail();
    }
}