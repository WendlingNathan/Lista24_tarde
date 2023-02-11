package com.example.atividade_tarde.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.atividade_tarde.model.Aluno;
import com.example.atividade_tarde.repository.AlunoRepository;

@RestController
@RequestMapping("api/alunos")
public class AlunoController {
	@Autowired
	private AlunoRepository repositorio;

	@GetMapping("/filtro")
	List<Aluno> findByFiltro(@RequestParam("filtro") String filtro) {
		return repositorio.findByFiltro(filtro);
	}

	@GetMapping("/")
	public Iterable<Aluno> findAll() {
		return repositorio.findAll();
	}

	@GetMapping("/salario")
	List<Aluno> porSalario(@RequestParam("salario") BigDecimal salario) {
		return repositorio.porSalario(salario);
	}

	// Incluir alunos
	@PutMapping("/alunos")
	public Aluno salvarAluno(@RequestBody Aluno aluno) {
		repositorio.save(aluno);

		System.out.println("Inserindo novo aluno...");
		System.out.println(aluno);

		return aluno;
	}

	// Atualizar aluno
//	@PutMapping("/alunos")
//	public Aluno atualizarAluno(@RequestBody Aluno aluno) {
//		Aluno a = repositorio.findById(aluno.getId());
//		
//		a.setNome(aluno.getNome());
//		a.setSalario(aluno.getSalario());
//		a.setNascimento(aluno.getNascimento());
//		
//		System.out.println("Atualizando aluno...");
//		System.out.println(a);
//		
//		return a;
//	}

//	// Deletar aluno
//	@DeleteMapping(value = "/alunos/{id}")
//	public void deletarAluno(@PathVariable Long id) {
//		Aluno a = repositorio.findById(id);
//		repositorio.delete(a);
//		System.out.println("Excluindo aluno [" + id + "]...");
//	}

}
