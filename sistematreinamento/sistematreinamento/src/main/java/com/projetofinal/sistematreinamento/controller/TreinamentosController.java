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

import com.projetofinal.sistematreinamento.model.Treinamento;
import com.projetofinal.sistematreinamento.repository.TreinamentosRepository;

@RestController
@Controller
@RequestMapping("/treinamentos")

public class TreinamentosController {
	
	TreinamentosRepository treinamentoRepository;
	
	public TreinamentosController(TreinamentosRepository treinamentoRepository)
	{
		this.treinamentoRepository = treinamentoRepository;
	}
	
	// insere treinamento
	@PostMapping("/insereTreinamento")
	public void insereTreinamento(@RequestBody Treinamento treinamento)
	{
		treinamentoRepository.save(treinamento);
	}
	
	//lista treinamentos
	@GetMapping("/listaTreinamentos")
	public List<Treinamento> listaTreinamentos()
	{
		return treinamentoRepository.findAll();
	}
	
	@PutMapping("/editaTreinamento/{codigo}")
	public void editaTreinamento(@RequestBody Treinamento treinamento, @PathVariable Long codigo)
	{
		if(treinamentoRepository.existsById(codigo)){
            treinamento.setCodigo(codigo);
            treinamentoRepository.save(treinamento);
        } else {
            System.out.println("Não encontrado.");
        }
		
	}
	
	@DeleteMapping("deletaTreinamento/{codigo}")
	public void deletaTreinamento(@PathVariable Long codigo)
	{
		
		if (treinamentoRepository.findById(codigo).isPresent())
		{
			treinamentoRepository.deleteById(codigo);
		}
	}
	
}
