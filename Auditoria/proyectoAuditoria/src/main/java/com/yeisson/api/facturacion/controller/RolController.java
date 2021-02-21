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

import com.yeisson.api.facturacion.models.Rol;
import com.yeisson.api.facturacion.service.RolService;

@RestController
@RequestMapping("/api")
public class RolController {
	
	@Autowired
	private RolService rolService;
	
	@PostMapping("/rol")
	public Rol addRol(@Validated @RequestBody Rol rol) {
		return rolService.agregarRol(rol);
	}
	
	@GetMapping("/roles")
	public List<Rol> getRoles() {
		return rolService.getRoles();
	}
	
	@GetMapping("/rol/{idRol}")
	public Rol getByIdRol(@PathVariable(value = "idRol") int idRol) {
		return rolService.getByIdRol(idRol);
	}
	
	@DeleteMapping("/rol/{idRol}")
	public void deleteRol(@PathVariable(value = "idRol") int idRol) {
		rolService.eliminarRol(idRol);
	}
	
	@PutMapping("/rol/{idRol}")
	public Rol updateRol(@PathVariable(value = "idRol") int idRol, 
						@Validated @RequestBody Rol rol) {
		return rolService.updateRol(idRol, rol);
	}

}
