package com.zends.condominio.advertencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zends.condominio.advertencia.domains.Advertencia;
import com.zends.condominio.advertencia.repository.IAdvertenciaRepository;
import com.zends.condominio.comum.service.AbstractService;

@Service
public class AdvertenciaService implements AbstractService< Advertencia > {

	@Autowired
	private IAdvertenciaRepository dao;
	
	@Override
	public ResponseEntity<?> getObj(Long idObj ) {
		Optional< Advertencia > advertencia = dao.findById( idObj );
		if( !advertencia.isPresent() )
			return new ResponseEntity< Advertencia >( HttpStatus.NOT_FOUND );
		
		return new ResponseEntity< Advertencia >( advertencia.get(), HttpStatus.OK );
	}

	@Override
	public ResponseEntity<List<Advertencia>> getList() {
		List< Advertencia > advertenciaList = dao.findAll();
		if( advertenciaList.isEmpty() )
			return new ResponseEntity< List< Advertencia >>( HttpStatus.NOT_FOUND );
		
		return new ResponseEntity< List< Advertencia >>( advertenciaList, HttpStatus.OK );
	}

	@Override
	@Transactional
	public ResponseEntity<?> save(Advertencia obj) {
		obj = dao.save( obj );
		if( obj.getId() == null )
			return new ResponseEntity< Advertencia >( HttpStatus.NOT_FOUND );
		
		return new ResponseEntity< Advertencia >( obj, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<?> update(Advertencia obj) {
		obj = dao.save( obj );
		
		return new ResponseEntity< Advertencia > ( obj, HttpStatus.OK );
	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(Long idObj) {
		dao.deleteById( idObj );
		
		return ResponseEntity.ok().body( "Registro excluido com sucesso." );
	}

}
