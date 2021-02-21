package com.yeisson.api.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeisson.api.facturacion.exception.ResourceNotFoundException;
import com.yeisson.api.facturacion.models.Inventario;
import com.yeisson.api.facturacion.repository.InventarioRepository;
import com.yeisson.api.facturacion.repository.ProductoRepository;

@Service
public class InventarioServiceImp implements InventarioService {
	
	private Inventario inventario;
	@Autowired
	private InventarioRepository inventarioRepository;
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Inventario> getInventarios() {
		return inventarioRepository.findAll();
	}

	@Override
	public Inventario getByIdInventario(int id) {
		return inventarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("inventario", "id", "Obtener inventario id", id));
	}

	@Override
	public Inventario agregarInventario(int idProducto, Inventario inventario) {
		
		this.inventario = inventario;
		productoRepository.findById(idProducto).map(producto -> {
			this.inventario.setProducto(producto);
			return this.inventario;
		}).orElseThrow(() -> new ResourceNotFoundException("Producto", "id", "Producto en agregar Inventario", idProducto));
		
		return inventarioRepository.save(inventario);
	}

	@Override
	public Inventario updateInventario(int idProducto, int idInvetario, Inventario inventarioNuevo) {
		
		if (!productoRepository.existsById(idProducto)) {
			throw new ResourceNotFoundException("Producto", "id","Producto en actualizar inventario", idProducto);
		}
		return inventarioRepository.findById(idInvetario).map(inventario ->{
			inventario.setCondicion(inventarioNuevo.getCondicion());
			inventario.setFecha(inventarioNuevo.getFecha());
			inventario.setCantidad(inventarioNuevo.getCantidad());
			return inventarioRepository.save(inventario);
		}).orElseThrow(() -> new ResourceNotFoundException("Inventario", "id","Actualizar Inventario", idInvetario));
	}

	@Override
	public void eliminarInventario(int id) {
		Inventario inventario = inventarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("inventario", "id", "Obtener inventario id", id));
		
		inventarioRepository.delete(inventario);
	}

}
