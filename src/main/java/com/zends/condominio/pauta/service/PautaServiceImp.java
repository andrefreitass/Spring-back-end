package com.zends.condominio.pauta.service;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;

import com.zends.condominio.comum.service.AbstractService;

public interface PautaServiceImp<T> extends AbstractService<T>{
	ResponseEntity<?> buscarPautaData(LocalDate dataInicio, LocalDate dataFim);
}
