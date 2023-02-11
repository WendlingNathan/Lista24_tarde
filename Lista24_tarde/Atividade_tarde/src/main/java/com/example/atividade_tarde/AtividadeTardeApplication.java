package com.example.atividade_tarde;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.atividade_tarde.model.Aluno;
import com.example.atividade_tarde.repository.AlunoRepository;

@SpringBootApplication
public class AtividadeTardeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtividadeTardeApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandoLineRunner(AlunoRepository repositorio) {
		return args -> {
			Aluno a = new Aluno(null, "Marcos", new BigDecimal("2000"), new Date());
			repositorio.save(a);
			
			Optional<Aluno> p = repositorio.findById(2L);
			if (p.isPresent()) {
				System.out.println("Registro foi encontrado com sucesso!!!");
			} else {
				System.out.println("Registro não encontrado!");
			}
		};
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedOrigins("*")
					.allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}
}
