package com.zends.condominio.funcionario.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.zends.condominio.comum.exception.DataException;
import com.zends.condominio.comum.exception.ObjectNotFoundException;
import com.zends.condominio.comum.service.AbstractService;
import com.zends.condominio.funcionario.domains.Funcionario;
import com.zends.condominio.funcionario.repository.FuncionarioRepository;





@Service
public class FuncionarioService implements AbstractService<Funcionario> {

	@Autowired
	private FuncionarioRepository dao;

	@Override
	public ResponseEntity<Funcionario> getObj(Long idFuncionario) {
		Optional<Funcionario> funcionario = dao.findById(idFuncionario);
		if (!funcionario.isPresent()) {
			
			throw new ObjectNotFoundException("no busca funcionario: " + idFuncionario
					+ "" + Funcionario.class.getName());
			
		}
		
		return new ResponseEntity<Funcionario>(funcionario.get(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Funcionario>> getList() {
		// TODO Auto-generated method stub
		List<Funcionario> listaFuncionario = dao.findAll();
		if (listaFuncionario.isEmpty() ) {
			throw new ObjectNotFoundException("lista funcionario vazio");
		}
		
		return new ResponseEntity<List<Funcionario>>(listaFuncionario, HttpStatus.OK);
		
	}
	
	

	@Override
	@Transactional
	public ResponseEntity<Funcionario> save(Funcionario funcionario) {
		// TODO Auto-generated method stub
		funcionario = dao.save(funcionario);
		if (funcionario.getId() == null) {
			throw new DataException("no funcionario cadastro" + Funcionario.class.getName());
		}
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<Funcionario> update(Funcionario funcionario) {
		// TODO Auto-generated method stub
		if (funcionario.getId() == null) {
			throw new ObjectNotFoundException("no funcionario atualiza" + funcionario.getId()
			+ "" + Funcionario.class.getName());
		}
		getObj(funcionario.getId());
		funcionario = dao.save(funcionario);
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<String> delete(Long idDominio) {
		// TODO Auto-generated method stub
		
		getObj(idDominio);
		dao.deleteById(idDominio);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	

}
