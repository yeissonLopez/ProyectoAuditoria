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

import com.yeisson.api.facturacion.models.Inventario;
import com.yeisson.api.facturacion.service.InventarioService;

@RestController
@RequestMapping("/api")
public class InventarioController {
	
	@Autowired
	private InventarioService inventarioService;
	
	@PostMapping("/producto/{idProducto}/inventario")
	public Inventario addInventario(@PathVariable(value = "idProducto") int idProducto, 
										@Validated @RequestBody Inventario inventario) {
		return inventarioService.agregarInventario(idProducto, inventario);
		
	}
	
	@GetMapping("/inventarios")
	public List<Inventario> getInventarios() {
		return inventarioService.getInventarios();
	}
	
	@GetMapping("/inventario/{idInventario}")
	public Inventario getByIdInventario(@PathVariable(value = "idInventario") Integer idInventario) {
		return inventarioService.getByIdInventario(idInventario);
	}
	
	@DeleteMapping("/inventario/{idInventario}")
	public void deleteInventario(@PathVariable(value = "idInventario") Integer idInventario) {
		inventarioService.eliminarInventario(idInventario);
	}
	
	@PutMapping("/producto/{idProducto}/inventario/{idInventario}")
	public Inventario updateInventario(@PathVariable(value = "idProducto") int idProducto, 
									@PathVariable(value = "idInventario") int idInventario, 
									@Validated @RequestBody Inventario inventario) {
		return inventarioService.updateInventario(idProducto, idInventario, inventario);
	}

}
