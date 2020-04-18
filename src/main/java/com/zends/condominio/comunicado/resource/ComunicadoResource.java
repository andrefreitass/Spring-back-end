package com.zends.condominio.comunicado.resource;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.zends.condominio.comum.uteis.Log;
import com.zends.condominio.comunicado.domain.Comunicado;
import com.zends.condominio.comunicado.service.ComunicadoServiceImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/comunicado")
public class ComunicadoResource {
	
	@Autowired
	private ComunicadoServiceImp<Comunicado> service;
	
	@GetMapping
	private ResponseEntity<List<Comunicado>> getList(){
		Log.info("Inicia a busca de todos os comunicados");
		return service.getList();		
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<?> getComunicado(@PathVariable("id") Long idDominio) {
		Log.info("Realiza a busca de um Comunicado recebida via ID");
		return service.getObj(idDominio);
	}
	
	@GetMapping("/{dataInicio}/{dataFim}")
	private ResponseEntity<?> buscaPautaData(
			@PathVariable(value = "dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
			@PathVariable(value = "dataFim")    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {
		return service.buscarComunicadoData(dataInicio, dataFim);
	}
	
	@PostMapping
	private ResponseEntity<?> save(@RequestBody Comunicado comunicado) {
		Log.info("Realiza o cadastro de um novo Comunicado");
		return service.save(comunicado);
	}

	@PutMapping
	private ResponseEntity<?> update(@RequestBody Comunicado comunicado) {
		Log.info("Realiza a atualizacao de um Comunicado");
		return service.update(comunicado);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable("id") Long idComunicado) {
		Log.info("Realiza a exclusao de um Comunicado");
		return service.delete(idComunicado);
	}


}
