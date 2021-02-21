package com.yeisson.api.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeisson.api.facturacion.exception.ResourceNotFoundException;
import com.yeisson.api.facturacion.models.Empleado;
import com.yeisson.api.facturacion.repository.EmpleadoRepository;
import com.yeisson.api.facturacion.repository.RolRepository;
@Service
public class EmpleadoServiceImp implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private RolRepository rolRepository;
	private Empleado empleado;

	@Override
	public List<Empleado> getEmpleados() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado getByIdEmpleado(int id) {
		return empleadoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("empleado", "id", "Obtener Empleado id", id));
	}

	@Override
	public Empleado agregarEmpleado(int idRol,Empleado empleado) {
		this.empleado = empleado;
		
		rolRepository.findById(idRol).map(rol->{
			//this.empleado.setRolesEmpleado(this.empleado.getRolesEmpleado().add(rol);
			this.empleado.getRolesEmpleado().add(rol);
			return this.empleado;
		}).orElseThrow(() -> new ResourceNotFoundException("Rol", "id","Agregar Rol a Empleado", idRol));
		
		return empleadoRepository.save(empleado);
	}

	@Override
	public Empleado updateEmpleado(int idRol,int idEmpleado, Empleado empleadoNuevo) {
		
		if (!rolRepository.existsById(idRol)) {
			throw new ResourceNotFoundException("Rol", "id","No existe Rol para actualizar Empleado", idRol);
		}
		return empleadoRepository.findById(idEmpleado).map(empleado ->{
			empleado.setNombre(empleadoNuevo.getNombre());
			empleado.setApellido(empleadoNuevo.getApellido());
			empleado.setGenero(empleadoNuevo.getGenero());
			empleado.setEmail(empleadoNuevo.getEmail());
			empleado.setTelefono(empleadoNuevo.getTelefono());
			empleado.setDireccion(empleadoNuevo.getDireccion());
			empleado.setRolesEmpleado(empleadoNuevo.getRolesEmpleado());
			return empleadoRepository.save(empleado);
		}).orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", "No se encontro empleado: ", idEmpleado));
	}

	@Override
	public void eliminarEmpleado(int id) {
		Empleado empleado = empleadoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("empleado", "id", "Obtener Empleado id", id));
		
		empleadoRepository.delete(empleado);
	}

}
