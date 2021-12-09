package com.projetofinal.sistematreinamento.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetofinal.sistematreinamento.model.Empregado;
import com.projetofinal.sistematreinamento.repository.EmpregadosRepository;

@RestController
@Controller
@RequestMapping("/empregados")


public class EmpregadosController {


		EmpregadosRepository empregadosRepository;
		
		public EmpregadosController(EmpregadosRepository empregadosRepository)
		{
			this.empregadosRepository = empregadosRepository;
		}
		
		// insere empregado
		@PostMapping("inserirEmpregado")
		public void insereEmpregado(@RequestBody Empregado empregado)
		{
			empregadosRepository.save(empregado);
		}
		
		//lista Empregado
		@GetMapping("/listaEmpregado")
		public List<Empregado> lerEmpregado()
		{
			return empregadosRepository.findAll();
		}
		
		@PutMapping("/atualizaEmpregado/{matricula}")
		public void edita(@RequestBody Empregado empregado, @PathVariable Long matricula) 
		{
			if (empregadosRepository.existsById(matricula))
			{
				empregado.setMatricula(matricula);
				empregadosRepository.save(empregado);
			}
			else 
			{
				System.out.println("empregado não existe");
			}
		}
		
		@DeleteMapping("/deletaEmpregado/{matricula}")
		public void deletaEmpregado(@PathVariable Long matricula)
		{
			
			Optional<Empregado> empregado = empregadosRepository.findById(matricula);
			if (empregado.isPresent())
			{
				empregadosRepository.deleteById(matricula);
			}
			
		}
	}


