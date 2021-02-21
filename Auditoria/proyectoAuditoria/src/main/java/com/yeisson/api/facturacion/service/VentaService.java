package com.yeisson.api.facturacion.service;

import java.util.List;

import com.yeisson.api.facturacion.models.Venta;

public interface VentaService {
	
	public List<Venta> getVentas();
	public Venta getByIdVenta(int id);
	public Venta agregarVenta(int idProducto, int idFactura,Venta venta);
	public Venta updateVenta(int idProducto, int idFactura, int idVenta,Venta venta);
	public void eliminarVenta(int id);

}
