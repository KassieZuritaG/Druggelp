package com.ortizzurita.druggelp.models.entities;
import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="farmaco")
public class Farmaco implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_farmaco")
	private long idfarmaco;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="costo")
	private float costo;
	
	@Column(name="fecha_expiracion")
	private Calendar fechaExpiracion;
	
	@Column(name="cantidad")
	private Integer cantidad;

	@Column(name="tipo_medicamento")
	private String tipoMedicamento;

	public Farmaco() {
		super();
	}

	public Farmaco(long id) {
		super();
		this.idfarmaco = id;
	}

	public long getIdfarmaco() {
		return idfarmaco;
	}

	public void setIdfarmaco(long idfarmaco) {
		this.idfarmaco = idfarmaco;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public Calendar getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Calendar fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(String tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}	
}
