package com.yeisson.api.facturacion.service;

import java.util.List;

import com.yeisson.api.facturacion.models.Producto;


public interface ProductoService {
	
	public List<Producto> getProductos();
	public Producto getByIdProducto(int id);
	public Producto agregarProducto(int idProveedor,Producto producto);
	public Producto updateProducto(int idProveedor, int idProducto,Producto producto);
	public void eliminarProducto(int id);
}
