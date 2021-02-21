package com.yeisson.api.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeisson.api.facturacion.exception.ResourceNotFoundException;
import com.yeisson.api.facturacion.models.Producto;
import com.yeisson.api.facturacion.repository.ProductoRepository;
import com.yeisson.api.facturacion.repository.ProveedorRepository;

@Service
public class ProductoServiceImp implements ProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	private Producto producto;

	@Override
	public List<Producto> getProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto getByIdProducto(int id) {
		return productoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto", "id", "Obtener producto id", id));
	}

	@Override
	public Producto agregarProducto(int idProveedor, Producto producto) {
		
		this.producto = producto;
		
		proveedorRepository.findById(idProveedor).map(proveedor -> {
			this.producto.setProveedor(proveedor);
			return this.producto;
		}).orElseThrow(() -> new ResourceNotFoundException("Proveedor", "id", "Proveedor en agregar Producto", idProveedor));
		return productoRepository.save(producto);
	}

	@Override
	public Producto updateProducto(int idProveedor, int idProducto, Producto productoNuevo) {
		if (!proveedorRepository.existsById(idProveedor)) {
			throw new ResourceNotFoundException("Proveedor", "id","Proveedor en actualizar Producto", idProveedor);
		}
		return productoRepository.findById(idProducto).map(producto ->{
			producto.setNombreProducto(productoNuevo.getNombreProducto());
			producto.setPresentacion(productoNuevo.getPresentacion());
			producto.setPesoNeto(productoNuevo.getPesoNeto());
			producto.setObservacion(productoNuevo.getObservacion());
			producto.setTipoProducto(productoNuevo.getTipoProducto());
			producto.setUnidadMedida(productoNuevo.getUnidadMedida());
			return productoRepository.save(producto);
		}).orElseThrow(() -> new ResourceNotFoundException("Producto", "id","Actualizar Producto", idProducto));
	}

	@Override
	public void eliminarProducto(int id) {
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Producto", "id", "Obtener producto id", id));
		
		productoRepository.delete(producto);
	}

}
