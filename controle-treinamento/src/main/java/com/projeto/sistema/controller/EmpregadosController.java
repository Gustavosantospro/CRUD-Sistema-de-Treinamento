package com.projeto.sistema.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.sistema.model.Empregado;
import com.projeto.sistema.repository.EmpregadosRepository;

@RestController
@Controller("/empregados")

public class EmpregadosController {

	EmpregadosRepository empregadosRepository;
	
	public EmpregadosController(EmpregadosRepository empregadosRepository)
	{
		this.empregadosRepository = empregadosRepository;
	}
	
	
	@PostMapping("inserirEmpregado")
	public void insereEmpregado(@RequestBody Empregado empregado)
	{
		empregadosRepository.save(empregado);
	}
	
	@GetMapping("/listaEmpregado")
	public List<Empregado> lerEmpregado()
	{
		List<Empregado> listaEmpregados;
		listaEmpregados = empregadosRepository.findAll();
		
		return listaEmpregados;
	}
	
	@PutMapping("/atualizaEmpregado")
	public void atualiza(@RequestBody Long matricula) 
	{
		
	}
}
