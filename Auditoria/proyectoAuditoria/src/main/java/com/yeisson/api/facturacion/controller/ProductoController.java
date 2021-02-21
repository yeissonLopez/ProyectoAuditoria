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

import com.yeisson.api.facturacion.models.Producto;
import com.yeisson.api.facturacion.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@PostMapping("/proveedor/{idProveedor}/producto")
	public Producto addProducto(@PathVariable(value = "idProveedor") int idProveedor, 
								@Validated @RequestBody Producto producto) {
		return productoService.agregarProducto(idProveedor, producto);
	}
	
	@GetMapping("/productos")
	public List<Producto> getProductos() {
		return productoService.getProductos();
	}
	
	@GetMapping("/producto/{idProducto}")
	public Producto getByIdProducto(@PathVariable(value = "idProducto") int idProducto) {
		return productoService.getByIdProducto(idProducto);
	}
	
	@DeleteMapping("/producto/{idProducto}")
	public void deleteProducto(@PathVariable(value = "idProducto") int idProducto) {
		productoService.eliminarProducto(idProducto);
	}
	
	@PutMapping("/producto/{idProducto}/proveedor/{idProveedor}")
	public Producto updateProducto(@PathVariable(value = "idProveedor") int idProveedor, 
									@PathVariable(value = "idProducto") int idProducto, 
									@Validated @RequestBody Producto producto) {
		return productoService.updateProducto(idProveedor, idProducto, producto);
	}

}
