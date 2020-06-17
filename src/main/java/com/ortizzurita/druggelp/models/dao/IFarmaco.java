package com.ortizzurita.druggelp.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ortizzurita.druggelp.models.entities.Farmaco;

public interface IFarmaco extends CrudRepository<Farmaco, Integer>{

}
