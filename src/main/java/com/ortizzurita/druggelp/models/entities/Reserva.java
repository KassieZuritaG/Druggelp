package com.ortizzurita.druggelp.models.entities;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_reserva")
	private long idreserva;
	
	@Column(name="fecha_reserva")
	private Calendar fechaReserva;

	public Reserva() {
		super();
	}

	public Reserva(long id) {
		super();
		this.idreserva = id;
	}

	public long getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(long idreserva) {
		this.idreserva = idreserva;
	}

	public Calendar getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Calendar fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	@OneToMany(mappedBy="reserva", fetch= FetchType.LAZY)
	private List<Farmaco> farmacos;

	public List<Farmaco> getFarmacos() {
		return farmacos;
	}

	public void setFarmacos(List<Farmaco> farmacos) {
		this.farmacos = farmacos;
	}
	
	@JoinColumn(name="fk_cliente", referencedColumnName="pk_persona")
	@ManyToOne
	private Cliente clientes;

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.getIdreserva());
	}
	
}
