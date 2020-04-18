package com.zends.condominio.funcionario.domains;


import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2581736598371625253L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	@NotNull(message = "O campo local deve ser informado")
	@Size(min = 5, max = 100, message = "O campo deve ter no minimo 5 caracteres e no maximo 100 caracteres")
	private String nome;



	@NotNull(message = "O campo data deve ser informado")
	@Column
	private Date data;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}


	
	
	
	
}

