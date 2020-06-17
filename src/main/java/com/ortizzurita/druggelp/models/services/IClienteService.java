package com.ortizzurita.druggelp.models.services;

import java.util.List;

import com.ortizzurita.druggelp.models.entities.Cliente;

public interface IClienteService {

	public void save(Cliente c);
	public Cliente findById(Integer id);
	public void delete(Integer id);
	public List<Cliente> findAll();
}
