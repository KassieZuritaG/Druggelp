package com.ortizzurita.druggelp.models.services;

import java.util.List;

import com.ortizzurita.druggelp.models.entities.Farmacia;

public interface IFarmaciaService {

	public void save(Farmacia f);
	public Farmacia findById(Integer id);
	public void delete(Integer id);
	public List<Farmacia> findAll();
}
