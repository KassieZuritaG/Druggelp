package com.ortizzurita.druggelp.models.services;

import java.util.List;

import com.ortizzurita.druggelp.models.entities.Farmaceutico;

public interface IFarmaceuticoService {

	public void save(Farmaceutico fm);
	public Farmaceutico findById(Integer id);
	public void delete(Integer id);
	public List<Farmaceutico> findAll();
}
