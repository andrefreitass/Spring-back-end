package com.zends.condominio.pauta.domains;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pauta implements Serializable {
	private static final long serialVersionUID = -6660916862753191168L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	@NotNull(message = "O campo local deve ser informado")
	@Size(min = 5, max = 100, message = "O campo deve ter no minimo 5 caracteres e no maximo 100 caracteres")
	private String local;

	@NotNull(message = "O campo assuntos deve ser informado")
	@Size(min = 5, max = 1000, message = "O campo deve ter no minimo 5 caracteres e no maximo 250 caracteres")
	@Column(length = 1000)	
	private String assuntos;

	@NotNull(message = "O campo data deve ser informado")
	@Column
	private LocalDate data;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(String assuntos) {
		this.assuntos = assuntos;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
}
