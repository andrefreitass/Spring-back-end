package com.zends.condominio.comunicado.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.sun.istack.Nullable;
import com.zends.condominio.pauta.domains.Pauta;

@Entity
public class Comunicado implements Serializable {
	private static final long serialVersionUID = -6660916862753191168L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O campo data deve ser informado")
	@Column	
	private LocalDateTime data;
	
	@Column(length = 100)
	@NotNull(message = "O campo titulo deve ser informado")
	@Size(min = 5, max = 100, message = "O campo deve ter no minimo 5 caracteres e no maximo 100 caracteres")
	private String titulo;
	
	@Column(length = 100)
	@NotNull(message = "O campo descricao deve ser informado")
	@Size(min = 5, max = 100, message = "O campo deve ter no minimo 5 caracteres e no maximo 100 caracteres")
	private String descricao;

	@OneToOne()
	private Pauta pautaAssuntos;

	public Pauta getPautaAssuntos() {	
		return pautaAssuntos;
		
	}

	public void setPautaAssuntos(Pauta pautaAssuntos) {
		this.pautaAssuntos = pautaAssuntos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}