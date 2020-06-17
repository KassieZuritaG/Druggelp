package com.ortizzurita.druggelp.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ortizzurita.druggelp.models.entities.Cliente;

public interface ICliente extends CrudRepository<Cliente, Integer>{

}
