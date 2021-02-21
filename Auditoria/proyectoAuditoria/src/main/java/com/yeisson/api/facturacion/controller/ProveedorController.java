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

import com.yeisson.api.facturacion.models.Proveedor;
import com.yeisson.api.facturacion.service.ProveedorService;

@RestController
@RequestMapping("/api")
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;
	
	@PostMapping("/proveedor")
	public Proveedor addProveedor(@Validated @RequestBody Proveedor proveedor) {
		return proveedorService.agregarProveedor(proveedor);
	}
	
	@GetMapping("/proveedores")
	public List<Proveedor> getProveedores() {
		return proveedorService.getProveedores();
	}
	
	@GetMapping("/proveedor/{idProveedor}")
	public Proveedor getByIdProveedor(@PathVariable(value = "idProveedor") int idProveedor) {
		return proveedorService.getByIdProveedor(idProveedor);
	}
	
	@DeleteMapping("/proveedor/{idProveedor}")
	public void deleteProveedor(@PathVariable(value = "idProveedor") int idProveedor) {
		proveedorService.eliminarProveedor(idProveedor);
	}
	
	@PutMapping("/proveedor/{idProveedor}")
	public Proveedor updateProveedor(@PathVariable(value = "idProveedor") int idProveedor, 
									@Validated @RequestBody Proveedor proveedor) {
		return proveedorService.updateProveedor(idProveedor, proveedor);
	}
}
