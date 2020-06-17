package com.ortizzurita.druggelp.models.services;

import java.util.List;

import com.ortizzurita.druggelp.models.entities.Reserva;

public interface IReservaService {

	public void save(Reserva r);
	public Reserva findById(Integer id);
	public void delete(Integer id);
	public List<Reserva> findAll();
}
