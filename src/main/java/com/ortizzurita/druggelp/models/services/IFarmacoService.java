package com.ortizzurita.druggelp.models.services;

import java.util.List;

import com.ortizzurita.druggelp.models.entities.Farmaco;

public interface IFarmacoService {

	public void save(Farmaco far);
	public Farmaco findById(Integer id);
	public void delete(Integer id);
	public List<Farmaco> findAll();
}
