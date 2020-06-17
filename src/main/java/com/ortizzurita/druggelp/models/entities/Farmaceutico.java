package com.ortizzurita.druggelp.models.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "farmaceuticos")
public class Farmaceutico extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="fecha_ingreso")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Calendar fechaIngreso;
	
	@Column(name="tipo_contrato")
	private String tipoContrato;

	public Farmaceutico() {
		super();
	}
	
	public Farmaceutico(long id) {
		super();
		this.setIdpersona(id);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	
	public String fechaIngreso() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");		
		return sdf.format(fechaIngreso.getTime());
	}
	
}
