package com.springboot.projectweb.models.service;

import java.util.List;

import com.springboot.projectweb.models.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado> listEmpleados();

	public void Save(Empleado empleado);

	public void Update(Empleado empleado);

	public Empleado findEmpleado(Empleado empleado);
	
	public void Eliminar(Empleado empelado);

}
