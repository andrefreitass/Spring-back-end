package com.zends.condominio.cap.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.zends.condominio.cap.domains.Dominio;

public interface IDominioService {

	ResponseEntity< Dominio > getDominio( Long idDominio );
	
	ResponseEntity< List< Dominio >> getList();
	
	ResponseEntity< Dominio > save( Dominio dominio );
	
	ResponseEntity< Dominio > update( Dominio dominio );
	
	ResponseEntity< String > delete( Long idDominio );
	
}
