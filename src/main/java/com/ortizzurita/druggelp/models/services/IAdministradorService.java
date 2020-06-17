package com.ortizzurita.druggelp.models.services;

import java.util.List;
import com.ortizzurita.druggelp.models.entities.Administrador;

public interface IAdministradorService {

	public void save(Administrador a);
	public Administrador findById(Integer id);
	public void delete(Integer id);
	public List<Administrador> findAll();
}
