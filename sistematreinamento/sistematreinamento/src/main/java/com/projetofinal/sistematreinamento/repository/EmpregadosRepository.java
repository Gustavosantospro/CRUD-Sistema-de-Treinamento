package com.projetofinal.sistematreinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.sistematreinamento.model.Empregado;



public interface EmpregadosRepository extends JpaRepository<Empregado, Long> {

}