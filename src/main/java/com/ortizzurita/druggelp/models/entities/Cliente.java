package com.ortizzurita.druggelp.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy="clientes", fetch= FetchType.LAZY)
	private List<Reserva> reservas;

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
