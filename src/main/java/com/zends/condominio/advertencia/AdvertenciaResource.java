package com.zends.condominio.advertencia;

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

import com.zends.condominio.advertencia.domains.Advertencia;
import com.zends.condominio.comum.service.AbstractService;

@CrossOrigin("*")
@RestController
@RequestMapping("/advertencias")
public class AdvertenciaResource {

	@Autowired
	private AbstractService< Advertencia > service;
	
	@GetMapping("/{id}")
	private ResponseEntity< ? > getAdvertencia( @PathVariable("id") Long id ) {
		
		return service.getObj( id ); 
	}
	
	@GetMapping
	private ResponseEntity< List< Advertencia >> getList() {
		
		return service.getList();
	}
	
	@PostMapping
	private ResponseEntity<?> save( @RequestBody Advertencia advertencia ) {
		
		return service.save( advertencia );
	}
	
	@PutMapping
	private ResponseEntity<?> update( @RequestBody Advertencia advertencia ) {
		
		return service.update( advertencia );
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?> delete( @PathVariable Long id ) {
		
		return service.delete( id );
	}
}
