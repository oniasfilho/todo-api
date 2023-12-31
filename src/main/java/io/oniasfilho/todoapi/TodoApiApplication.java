package io.oniasfilho.todoapi;

import io.oniasfilho.todoapi.dto.RegisterRequest;
import io.oniasfilho.todoapi.model.Role;
import io.oniasfilho.todoapi.security.config.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApiApplication.class, args);
	}
}
