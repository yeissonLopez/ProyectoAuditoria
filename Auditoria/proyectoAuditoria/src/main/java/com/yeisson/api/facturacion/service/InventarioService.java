package com.yeisson.api.facturacion.service;

import java.util.List;

import com.yeisson.api.facturacion.models.Inventario;


public interface InventarioService {
	
	public List<Inventario> getInventarios();
	public Inventario getByIdInventario(int id);
	public Inventario agregarInventario(int idProducto,Inventario inventario);
	public Inventario updateInventario(int idProducto,int idInventario,Inventario inventario);
	public void eliminarInventario(int id);

}
