package com.zends.condominio.funcionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zends.condominio.funcionario.domains.Funcionario;

@Repository 
public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {

}
