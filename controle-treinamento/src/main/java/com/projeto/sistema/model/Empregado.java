package com.projeto.sistema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Empregado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long matricula;
	
	private String nome;
	private String sexo;
}
