package com.ortizzurita.druggelp.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Persona implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="identificador")
	private String identificador;

	public Cliente() {
		super();
	}
	
	public Cliente(long id) {
		super();
		this.setPk_persona(id);
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}
