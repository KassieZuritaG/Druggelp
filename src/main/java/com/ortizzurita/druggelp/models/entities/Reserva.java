package com.ortizzurita.druggelp.models.entities;
import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
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
	
	
	public Farmacia getBotica() {
		return botica;
	}

	public void setBotica(Farmacia botica) {
		this.botica = botica;
	}

	@JoinColumn(name="fk_botica", referencedColumnName="pk_farmaco")
	@ManyToOne
	private Farmacia botica;
}
