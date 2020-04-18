package com.zends.condominio.cap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zends.condominio.cap.domains.Dominio;
import com.zends.condominio.cap.repository.IDominioRepository;
import com.zends.condominio.comum.service.AbstractService;

@Service
public class DominioService implements AbstractService< Dominio > {

	@Autowired
	private IDominioRepository dao;
	
	@Override
	public ResponseEntity<Dominio> getObj(Long idDominio) {
		Optional< Dominio > dominio = dao.findById( idDominio );
		if( !dominio.isPresent() )
			return new ResponseEntity< Dominio >( HttpStatus.NOT_FOUND );
		
		return new ResponseEntity< Dominio >( dominio.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Dominio>> getList() {
		List< Dominio > dominioList = dao.findAll();
		if( dominioList.isEmpty() )
			return new ResponseEntity< List< Dominio >> ( HttpStatus.NOT_FOUND );
		
		return new ResponseEntity< List< Dominio >> ( dominioList, HttpStatus.OK );
	}

	@Override
	@Transactional
	public ResponseEntity<Dominio> save(Dominio dominio) {
		dominio = dao.save( dominio );
		if( dominio.getId() == null )
			return new ResponseEntity<>( HttpStatus.NOT_FOUND );
		
		return new ResponseEntity< Dominio > ( dominio, HttpStatus.OK ) ;
	}

	@Override
	@Transactional
	public ResponseEntity<Dominio> update(Dominio dominio) {
		dominio = dao.save( dominio );
		
		return new ResponseEntity< Dominio > ( dominio, HttpStatus.OK );
	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(Long idDominio) {
		dao.deleteById( idDominio );
		
		return ResponseEntity.ok().body( "Registro excluido com sucesso." );
	}

}
