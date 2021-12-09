package com.projeto.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.sistema.model.Empregado;

public interface EmpregadosRepository extends JpaRepository<Empregado, Long> {

}
