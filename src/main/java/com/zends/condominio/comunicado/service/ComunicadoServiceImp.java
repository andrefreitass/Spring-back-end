package com.zends.condominio.comunicado.service;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;

import com.zends.condominio.comum.service.AbstractService;

public interface ComunicadoServiceImp<T> extends AbstractService<T> {

	ResponseEntity<?> buscarComunicadoData(LocalDateTime dataInicio, LocalDateTime dataFim);
}
