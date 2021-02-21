package com.yeisson.api.facturacion.service;

import java.util.List;

import com.yeisson.api.facturacion.models.Proveedor;

public interface ProveedorService {
	
	public List<Proveedor> getProveedores();
	public Proveedor getByIdProveedor(int id);
	public Proveedor agregarProveedor(Proveedor proveedor);
	public Proveedor updateProveedor(int id,Proveedor proveedor);
	public void eliminarProveedor(int id);

}
