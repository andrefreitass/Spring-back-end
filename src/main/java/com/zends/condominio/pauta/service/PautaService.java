package com.zends.condominio.pauta.service;

import java.time.LocalDate;
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
import com.zends.condominio.pauta.domains.Pauta;
import com.zends.condominio.pauta.repository.PautaRepository;

@Service
public class PautaService implements PautaServiceImp<Pauta> {

	@Autowired
	private PautaRepository dao;

	@Autowired
	MessageSource messageSource;

	@Override
	public ResponseEntity<Pauta> getObj(Long idPauta) {
		Optional<Pauta> pauta = dao.findById(idPauta);
		if (!pauta.isPresent()) {
			throw new ObjectNotFoundException(messageSource.getMessage("erro.consulta", null, LocaleContextHolder.getLocale()));
		}
		return new ResponseEntity<Pauta>(pauta.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Pauta>> buscarPautaData(LocalDate dataInicio, LocalDate dataFim) {
		if (dataInicio.isAfter(dataFim)) {
			throw new ObjectNotFoundException(messageSource.getMessage("data.inicio", null, LocaleContextHolder.getLocale()));

		} else if (dataFim.isBefore(dataInicio)) {
			throw new ObjectNotFoundException(messageSource.getMessage("data.fim", null, LocaleContextHolder.getLocale()));
		}
		List<Pauta> listaPauta = dao.findByDataBetweenOrderByIdDesc(dataInicio, dataFim);
		if (listaPauta.isEmpty()) {
			throw new ObjectNotFoundException(messageSource.getMessage("registro.data.nao.encontrado", null, LocaleContextHolder.getLocale()));
		}

		return new ResponseEntity<List<Pauta>>(listaPauta, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Pauta>> getList() {
		List<Pauta> listaPauta = dao.findAllByOrderByDataDesc();
		if (listaPauta.isEmpty()) {
			throw new ObjectNotFoundException(String
					.format(messageSource.getMessage("lista.vazia", null, LocaleContextHolder.getLocale()), "Pauta"));
		}
		return new ResponseEntity<List<Pauta>>(listaPauta, HttpStatus.OK);
	}
	
	@Override
	@Transactional
	public ResponseEntity<Pauta> save(Pauta pauta) {
		pauta = dao.save(pauta);
		if (pauta.getId() == null) {
			throw new ObjectNotFoundException(String
					.format(messageSource.getMessage("erro.cadastro", null, LocaleContextHolder.getLocale()), "Pauta"));
		}

		return new ResponseEntity<Pauta>(pauta, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<Pauta> update(Pauta pauta) {
		if (pauta.getId() == null) {
			throw new ObjectNotFoundException(String
					.format(messageSource.getMessage("erro.atualizacao", null, LocaleContextHolder.getLocale()), "Pauta"));
		}
		getObj(pauta.getId());
		pauta = dao.save(pauta);
		return new ResponseEntity<Pauta>(pauta, HttpStatus.OK);

	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(Long idDominio) {
		getObj(idDominio);
		dao.deleteById(idDominio);
		return ResponseEntity.noContent().build();
	}

}
