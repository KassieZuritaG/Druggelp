package com.ortizzurita.druggelp.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ortizzurita.druggelp.models.dao.IFarmaco;
import com.ortizzurita.druggelp.models.entities.Farmaco;

@Service
public class FarmacoService implements IFarmacoService{

	@Autowired
	private IFarmaco dao;

	@Override
	@Transactional
	public void save(Farmaco far) {
		dao.save(far);
	}

	@Override
	@Transactional
	public Farmaco findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Farmaco> findAll() {
		return (List<Farmaco>) dao.findAll();
	}
}
