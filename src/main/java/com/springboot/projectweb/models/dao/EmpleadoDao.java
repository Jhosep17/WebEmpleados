package com.springboot.projectweb.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.projectweb.models.entity.Empleado;

public interface EmpleadoDao extends CrudRepository<Empleado, Long>{
	
}
