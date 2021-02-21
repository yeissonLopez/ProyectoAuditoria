package com.yeisson.api.facturacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yeisson.api.facturacion.models.Empleado;
import com.yeisson.api.facturacion.service.EmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@PostMapping("/empleado/rol/{idRol}")
	public Empleado addEmpleado(@PathVariable (value = "idRol") int idRol,
									@Validated @RequestBody Empleado empleado) {
		return empleadoService.agregarEmpleado(idRol, empleado);	
	}
	
	@DeleteMapping("/empleado/{idEmpleado}")
	public void deleteEmpleado(@PathVariable(value = "idEmpleado") Integer idEmpleado) {
		empleadoService.eliminarEmpleado(idEmpleado);
	}
	
	@GetMapping("/empleados")
	public List<Empleado> getEmpleados() {
		return empleadoService.getEmpleados();
	}
	
	@GetMapping("/empleado/{idEmpleado}")
	public Empleado getByIdEmpleado(@PathVariable(value = "idEmpleado") Integer idEmpleado) {
		return empleadoService.getByIdEmpleado(idEmpleado);
	}
	
	@PutMapping("/empleado/{idEmpleado}/rol/{idRol}")
	public Empleado updateEmpleado(@PathVariable(value = "idRol")int idRol,
									@PathVariable(value = "idEmpleado")int idEmpleado, 
									@Validated @RequestBody Empleado empleado) {
		return empleadoService.updateEmpleado(idRol, idEmpleado, empleado);
	}
	
}
