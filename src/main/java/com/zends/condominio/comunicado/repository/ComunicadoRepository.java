package com.zends.condominio.comunicado.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zends.condominio.comunicado.domain.Comunicado;

@Repository
public interface ComunicadoRepository extends JpaRepository< Comunicado, Long > {
	
public List<Comunicado> findAllByOrderByDataDesc();

public List<Comunicado> findByDataBetweenOrderByIdDesc(LocalDateTime dataInicio, LocalDateTime dataFim);

}
