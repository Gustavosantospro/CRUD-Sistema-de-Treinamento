package com.projeto.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema.model.Treinamento;

public interface TreinamentosRepository extends JpaRepository<Treinamento, Long> {

}
