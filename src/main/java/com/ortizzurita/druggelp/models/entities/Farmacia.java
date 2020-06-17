package com.ortizzurita.druggelp.models.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="farmacias")
public class Farmacia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="pk_farmacia")
	private Integer idfarmacia;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="telefono")
	private String telefono;
	
	@Column(name="direccion")
	private String direccion;

	@Column(name="ciudad")
	private String ciudad;
	
	public Farmacia() {
		super();
	}

	public Farmacia(Integer id) {
		super();
		this.idfarmacia = id;
	}

	public Integer getIdfarmacia() {
		return idfarmacia;
	}

	public void setIdfarmacia(Integer idfarmacia) {
		this.idfarmacia = idfarmacia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@OneToMany(mappedBy="farmacia", fetch= FetchType.LAZY)
	private List<Farmaco> farmacos;

	public List<Farmaco> getFarmacos() {
		return farmacos;
	}

	public void setFarmacos(List<Farmaco> farmacos) {
		this.farmacos = farmacos;
	}
	
	@Override
	public String toString() {
		return this.getNombre()+"-"+this.getCiudad();
	}
	
}
