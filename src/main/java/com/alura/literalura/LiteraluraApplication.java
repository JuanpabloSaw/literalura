package com.alura.literalura;

import com.alura.literalura.principal.Principal;
import com.alura.literalura.repositorio.IAutoresRepository;
import com.alura.literalura.repositorio.ILibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private IAutoresRepository autoresRepository;
	@Autowired
	private ILibrosRepository librosRepository;
	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(autoresRepository, librosRepository);
		principal.muestraElMenu();
	}
}
