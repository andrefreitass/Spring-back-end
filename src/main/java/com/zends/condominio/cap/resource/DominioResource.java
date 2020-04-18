package com.zends.condominio.cap.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zends.condominio.cap.domains.Dominio;
import com.zends.condominio.comum.service.AbstractService;

@CrossOrigin("*")
@RestController
@RequestMapping("/cap/dominios")
public class DominioResource {

	@Autowired
	private AbstractService<Dominio> service;
	
	@GetMapping
	private ResponseEntity< List< Dominio>> getList() {
		
		return service.getList();
	}
	
	@GetMapping("/{id}")
	private ResponseEntity< ? > getDominio( @PathVariable("id") Long idDominio ) {
		
		return service.getObj( idDominio );
	}
	
	@PostMapping
	private ResponseEntity< ? > save( @RequestBody Dominio dominio ) {
		
		return service.save( dominio );
	}
	
	@PutMapping
	private ResponseEntity< ? > update( @RequestBody Dominio dominio ) {
		
		return service.update( dominio );
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity< String > delete( @PathVariable("id") Long idDominio ) {
		
		return service.delete( idDominio );
	}
	
}
