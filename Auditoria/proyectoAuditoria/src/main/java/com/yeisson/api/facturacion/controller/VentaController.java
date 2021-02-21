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

import com.yeisson.api.facturacion.models.Venta;
import com.yeisson.api.facturacion.service.VentaService;

@RestController
@RequestMapping("/api")
public class VentaController {
	
	@Autowired
	private VentaService ventaService;
	
	@PostMapping("/producto/{idProducto}/factura/{idFactura}/venta")
	public Venta addVenta(@PathVariable(value = "idProducto") int idProducto, 
								@PathVariable(value = "idFactura") int idFactura,
								 @Validated @RequestBody Venta venta) {
		return ventaService.agregarVenta(idProducto, idFactura, venta);
	}
	
	@GetMapping("/ventas")
	public List<Venta> getVentas() {
		return ventaService.getVentas();
	}
	
	@GetMapping("/venta/{idVenta}")
	public Venta getByIdVenta(@PathVariable(value = "idVenta") int idVenta) {
		return ventaService.getByIdVenta(idVenta);
	}
	
	@DeleteMapping("/venta/{idVenta}")
	public void deleteVenta(@PathVariable(value = "idVenta") int idVenta) {
		ventaService.eliminarVenta(idVenta);
	}
	
	@PutMapping("/producto/{idProducto}/factura/{idFactura}/venta/{idVenta}")
	public Venta updateVenta(@PathVariable(value = "idProducto") int idProducto, 
							@PathVariable(value = "idFactura") int idFactura,
							@PathVariable(value = "idVenta") int idVenta, 
							@Validated @RequestBody Venta venta) {
		return ventaService.updateVenta(idProducto, idFactura, idVenta, venta);
	}

}
