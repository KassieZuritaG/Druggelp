package com.ortizzurita.druggelp.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ortizzurita.druggelp.models.dao.IPersona;
import com.ortizzurita.druggelp.models.entities.Persona;

@Service
public class PersonaService implements IPersonaService{

	@Autowired
	private IPersona dao;
	
	@Override
	@Transactional
	public void save(Persona p) {
		dao.save(p);
	}

	@Override
	@Transactional
	public Persona findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Persona> findAll() {
		return (List<Persona>) dao.findAll();
	}

	
	
}
