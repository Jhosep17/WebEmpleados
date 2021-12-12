package com.springboot.projectweb.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.projectweb.models.dao.EmpleadoDao;
import com.springboot.projectweb.models.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Empleado> listEmpleados() {
		return (List<Empleado>) empleadoDao.findAll();
	}

	@Override
	@Transactional
	public void Save(Empleado empleado) {
		empleadoDao.save(empleado);
	}

	@Override
	@Transactional
	public void Update(Empleado empleado) {
		empleadoDao.save(empleado);
	}

	@Override
    @Transactional(readOnly = true)
	public Empleado findEmpleado(Empleado empleado) {
		return empleadoDao.findById(empleado.getIdEmpleado()).orElse(null);
	}

	@Override
	@Transactional
	public void Eliminar(Empleado empelado) {
		empleadoDao.delete(empelado);
		
	}

}
