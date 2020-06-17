package com.ortizzurita.druggelp.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ortizzurita.druggelp.models.dao.IFarmacia;
import com.ortizzurita.druggelp.models.entities.Farmacia;

@Service
public class FarmaciaService implements IFarmaciaService{

	@Autowired
	private IFarmacia dao;
	
	@Override
	@Transactional
	public void save(Farmacia f) {
		dao.save(f);
	}

	@Override
	@Transactional
	public Farmacia findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);		
	}

	@Override
	@Transactional
	public List<Farmacia> findAll() {
		return (List<Farmacia>) dao.findAll();
	}

	
}
