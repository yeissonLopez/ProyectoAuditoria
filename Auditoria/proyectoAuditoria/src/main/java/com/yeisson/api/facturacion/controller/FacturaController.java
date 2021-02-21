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

import com.yeisson.api.facturacion.models.Factura;
import com.yeisson.api.facturacion.service.FacturaService;

@RestController
@RequestMapping("/api")
public class FacturaController {
	
	@Autowired
	private FacturaService facturaService;
	
	@PostMapping("/empleado/{idEmpleado}/cliente/{idCliente}/factura")
	public Factura addFactura(@PathVariable(value = "idEmpleado")int idEmpleado,
								 @PathVariable(value = "idCliente") int idCliente, 
								 @Validated @RequestBody Factura factura) {
		return facturaService.agregarFactura(idEmpleado, idCliente, factura);
	}
	
	@GetMapping("/facturas")
	public List<Factura> getFacturas() {
		return facturaService.getFacturas();
	}
	
	@GetMapping("/factura/{idFactura}")
	public Factura getByIdFactura(@PathVariable(value = "idFactura") Integer idFactura) {
		return facturaService.getByIdFactura(idFactura);
	}
	
	@DeleteMapping("/factura/{idFactura}")
	public void deleteFactura(@PathVariable(value = "idFactura") Integer idFactura) {
		facturaService.eliminarFactura(idFactura);
	}
	
	@PutMapping("/cliente/{idCliente}/empleado/{idEmpleado}/factura/{idFactura}")
	public Factura updateFactura(@PathVariable(value = "idCliente")int idCliente, 
								@PathVariable(value = "idEmpleado") int idEmpleado, 
								@PathVariable(value = "idFactura")int idFactura, 
								@Validated @RequestBody Factura factura) {
		return facturaService.updateFactura(idCliente, idEmpleado, idFactura, factura);
	}

}
