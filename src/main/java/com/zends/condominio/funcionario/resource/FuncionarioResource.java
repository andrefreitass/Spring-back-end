package com.zends.condominio.funcionario.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

import com.zends.condominio.comum.service.AbstractService;
import com.zends.condominio.comum.uteis.Log;
import com.zends.condominio.funcionario.domains.Funcionario;




@CrossOrigin("*")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {
	
	
	@Autowired
	private AbstractService<Funcionario> service;
	
	@GetMapping
	private HttpEntity<List<Funcionario>> getList(){
		Log.info("LIste get");
		return service.getList();
		
	}
	
	
	@GetMapping("/{id}")
	private ResponseEntity<?> getFuncionario(@PathVariable("id") Long IdDominio){
		Log.info("buca Funcinario ID");
		return service.getObj(IdDominio);
	}
	
	
	@PostMapping
	private ResponseEntity<?> save(@RequestBody Funcionario funcionario){
		Log.info("cadastro funcionario");
		return service.save(funcionario);
		
	}
	
	@PutMapping 
	private ResponseEntity<?> update (@RequestBody Funcionario funcionario) {
		Log.info("atualiza funcionario");
		return service.update(funcionario);
	}
	
	
	@DeleteMapping("/{id}")
	private ResponseEntity<String> delete(@PathVariable("id") Long idFuncionario){
		Log.info("exclui Funcionario");
		return service.delete(idFuncionario);
	}
	

}