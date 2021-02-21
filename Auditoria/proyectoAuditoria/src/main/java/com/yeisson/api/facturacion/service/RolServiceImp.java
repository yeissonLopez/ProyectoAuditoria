package com.yeisson.api.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeisson.api.facturacion.exception.ResourceNotFoundException;
import com.yeisson.api.facturacion.models.Rol;
import com.yeisson.api.facturacion.repository.RolRepository;

@Service
public class RolServiceImp implements RolService {
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public List<Rol> getRoles() {
		return rolRepository.findAll();
	}

	@Override
	public Rol getByIdRol(int id) {
		return rolRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Rol", "id", "Obtener Rol id", id));
	}

	@Override
	public Rol agregarRol(Rol rol) {
		return rolRepository.save(rol);
	}

	@Override
	public Rol updateRol(int idRol, Rol rolNuevo) {
		return rolRepository.findById(idRol).
				map(rol ->{
					rol.setUsuario(rolNuevo.getUsuario());
					rol.setClave(rolNuevo.getClave());
					rol.setRol(rolNuevo.getRol());
					return rolRepository.save(rol);
				}).orElseThrow(() -> new ResourceNotFoundException("Rol", "id", "Actualizar Rol", idRol));
	}

	@Override
	public void eliminarRol(int id) {
		Rol rol = rolRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Rol", "id", "Obtener Rol id", id));
		
		rolRepository.delete(rol);
	}

}
