package com.yeisson.api.facturacion.service;

import java.util.List;

import com.yeisson.api.facturacion.models.Rol;

public interface RolService {
	
	public List<Rol> getRoles();
	public Rol getByIdRol(int id);
	public Rol agregarRol(Rol rol);
	public Rol updateRol(int id,Rol rol);
	public void eliminarRol(int id);

}
