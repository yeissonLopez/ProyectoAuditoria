package com.yeisson.api.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeisson.api.facturacion.exception.ResourceNotFoundException;
import com.yeisson.api.facturacion.models.Proveedor;
import com.yeisson.api.facturacion.repository.ProveedorRepository;

@Service
public class ProveedorServiceImp implements ProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;

	@Override
	public List<Proveedor> getProveedores() {
		return proveedorRepository.findAll();
	}

	@Override
	public Proveedor getByIdProveedor(int id) {
		return proveedorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Proveedor", "id", "Obtener proveedor id", id));
	}

	@Override
	public Proveedor agregarProveedor(Proveedor proveedor) {
		return proveedorRepository.save(proveedor);
	}

	@Override
	public Proveedor updateProveedor(int idProveedor, Proveedor proveedorNuevo) {
		return proveedorRepository.findById(idProveedor).
				map(proveedor -> {
					proveedor.setNombre(proveedorNuevo.getNombre());
					proveedor.setApellido(proveedorNuevo.getApellido());
					proveedor.setGenero(proveedorNuevo.getGenero());
					proveedor.setEmail(proveedorNuevo.getEmail());
					proveedor.setTelefono(proveedorNuevo.getTelefono());
					proveedor.setDireccion(proveedor.getDireccion());
					return proveedorRepository.save(proveedor);
				}).orElseThrow(() -> new ResourceNotFoundException("Proveedor", "id", "Actualizar Proveedor", idProveedor));
	}

	@Override
	public void eliminarProveedor(int id) {
		Proveedor proveedor = proveedorRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Proveedor", "id", "Obtener proveedor id", id));
		
		proveedorRepository.delete(proveedor);
	}

}
