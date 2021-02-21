package com.yeisson.api.facturacion.service;

import java.util.List;

import com.yeisson.api.facturacion.models.Empleado;


public interface EmpleadoService {
	
	public List<Empleado> getEmpleados();
	public Empleado getByIdEmpleado(int id);
	public Empleado agregarEmpleado(int idRol,Empleado empleado);
	public Empleado updateEmpleado(int idRol,int id,Empleado empleado);
	public void eliminarEmpleado(int id);

}
