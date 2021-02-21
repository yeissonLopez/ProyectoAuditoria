package com.yeisson.api.facturacion.service;

import java.util.List;

import com.yeisson.api.facturacion.models.Factura;

public interface FacturaService {
	
	public List<Factura> getFacturas();
	public Factura getByIdFactura(int id);
	public Factura agregarFactura(int idEmpleado,int idCliente,Factura factura);
	public Factura updateFactura(int idCliente, int idEmpleado,int id,Factura factura);
	public void eliminarFactura(int id);

}
