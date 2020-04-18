package com.zends.condominio.comunicado.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zends.condominio.comum.exception.ObjectNotFoundException;
import com.zends.condominio.comunicado.domain.Comunicado;
import com.zends.condominio.comunicado.repository.ComunicadoRepository;
import com.zends.condominio.pauta.domains.Pauta;

@Service
public class ComunicadoService implements ComunicadoServiceImp<Comunicado> {

	@Autowired
	private ComunicadoRepository dao;

	@Autowired
	MessageSource messageSource;
	
	@Override
	public ResponseEntity<Comunicado> getObj(Long idComunicado) {
		Optional<Comunicado> comunicado = dao.findById(idComunicado);
		if (!comunicado.isPresent()) {
			throw new ObjectNotFoundException(messageSource.getMessage("erro.consulta", null, LocaleContextHolder.getLocale()));
		}
				
		return new ResponseEntity<Comunicado>(comunicado.get(), HttpStatus.OK);
	}


	@Override
	public ResponseEntity<List<Comunicado>> getList() {
		List<Comunicado> listaComunicado = dao.findAllByOrderByDataDesc();
		if (listaComunicado.isEmpty()) {
			throw new ObjectNotFoundException(String
					.format(messageSource.getMessage("lista.vazia", null, LocaleContextHolder.getLocale()), "Comunicado"));
		}
		return new ResponseEntity<List<Comunicado>>(listaComunicado, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<List<Comunicado>> buscarComunicadoData(LocalDateTime dataInicio, LocalDateTime dataFim) {
		if (dataInicio.isAfter(dataFim)) {
			throw new ObjectNotFoundException(messageSource.getMessage("data.inicio", null, LocaleContextHolder.getLocale()));

		} else if (dataFim.isBefore(dataInicio)) {
			throw new ObjectNotFoundException(messageSource.getMessage("data.fim", null, LocaleContextHolder.getLocale()));
		}
		List<Comunicado> listaComunicado = dao.findByDataBetweenOrderByIdDesc(dataInicio, dataFim);
		if (listaComunicado.isEmpty()) {
			throw new ObjectNotFoundException(messageSource.getMessage("registro.data.nao.encontrado", null, LocaleContextHolder.getLocale()));
		}

		return new ResponseEntity<List<Comunicado>>(listaComunicado, HttpStatus.OK);
	}


	@Override
	@Transactional
	public ResponseEntity<Comunicado> save(Comunicado comunicado) {
		comunicado = dao.save(comunicado);
		if (comunicado.getId() == null) {
			throw new ObjectNotFoundException(String
					.format(messageSource.getMessage("erro.cadastro", null, LocaleContextHolder.getLocale()), "Comunicado"));
		}

		return new ResponseEntity<Comunicado>(comunicado, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<Comunicado> update(Comunicado comunicado) {
		if (comunicado.getId() == null) {
			throw new ObjectNotFoundException(String
					.format(messageSource.getMessage("erro.atualizacao", null, LocaleContextHolder.getLocale()), "Comunicado"));
		}
		getObj(comunicado.getId());
		comunicado = dao.save(comunicado);
		return new ResponseEntity<Comunicado>(comunicado, HttpStatus.OK);

	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(Long idComunicado) {
		getObj(idComunicado);
		dao.deleteById(idComunicado);
		return ResponseEntity.noContent().build();
	}

}
