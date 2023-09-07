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

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = new RegisterRequest("Onias", "da Rocha Filho", "admin@gmail.com", "K1ngKunt4.", Role.ADMIN);
			System.out.println("Admin token: " + service.register(admin).token());
		};
	}

}
