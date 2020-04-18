package com.zends.condominio.comum.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface AbstractService< T > {

	ResponseEntity< ? > getObj( Long idObj );
	
	ResponseEntity< List< T >> getList();
	
	ResponseEntity< ? > save( T obj );
	
	ResponseEntity< ? > update( T obj );
	
	ResponseEntity< String > delete( Long idObj );

	//ResponseEntity< Void > delete( Long idObj );
}
