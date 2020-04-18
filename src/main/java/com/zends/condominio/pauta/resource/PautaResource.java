package com.zends.condominio.pauta.resource;

import java.time.LocalDate;
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
import com.zends.condominio.pauta.domains.Pauta;
import com.zends.condominio.pauta.service.PautaServiceImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/pauta")
public class PautaResource {

	@Autowired
	private PautaServiceImp<Pauta> service;

	@GetMapping
	private ResponseEntity<List<Pauta>> getList() {
		Log.info("Realiza a busca de todas as Pautas");
		return service.getList();
	}

	@GetMapping("/{id}")
	private ResponseEntity<?> getPauta(@PathVariable("id") Long idDominio) {
		Log.info("Realiza a busca de uma Pauta recebida via ID");
		return service.getObj(idDominio);
	}

	@GetMapping("/{dataInicio}/{dataFim}")
	private ResponseEntity<?> buscaPautaData(
			@PathVariable(value = "dataInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio,
			@PathVariable(value = "dataFim") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFim) {
		return service.buscarPautaData(dataInicio, dataFim);
	}

	@PostMapping
	private ResponseEntity<?> save(@RequestBody Pauta pauta) {
		Log.info("Realiza o cadastro de uma nova Pauta");
		return service.save(pauta);
	}

	@PutMapping
	private ResponseEntity<?> update(@RequestBody Pauta pauta) {
		Log.info("Realiza a atualizacao de uma nova Pauta");
		return service.update(pauta);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable("id") Long idPauta) {
 
		return service.delete(idPauta);
	}

}
