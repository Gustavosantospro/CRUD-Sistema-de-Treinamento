package com.projetofinal.sistematreinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetofinal.sistematreinamento.model.Treinamento;

public interface TreinamentosRepository extends JpaRepository<Treinamento, Long > {

}
