package com.ortizzurita.druggelp.models.services;

import java.util.List;

import com.ortizzurita.druggelp.models.entities.Persona;

public interface IPersonaService {

	public void save(Persona p);
	public Persona findById(Integer id);
	public void delete(Integer id);
	public List<Persona> findAll();
}
