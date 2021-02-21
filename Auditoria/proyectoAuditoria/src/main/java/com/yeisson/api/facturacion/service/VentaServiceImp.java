package com.yeisson.api.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeisson.api.facturacion.exception.ResourceNotFoundException;
import com.yeisson.api.facturacion.models.Venta;
import com.yeisson.api.facturacion.repository.FacturaRepository;
import com.yeisson.api.facturacion.repository.ProductoRepository;
import com.yeisson.api.facturacion.repository.VentaRepository;

@Service
public class VentaServiceImp implements VentaService {
	
	private Venta venta;
	
	@Autowired
	private VentaRepository ventaRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private FacturaRepository facturaRepository;

	@Override
	public List<Venta> getVentas() {
		return ventaRepository.findAll();
	}

	@Override
	public Venta getByIdVenta(int id) {
		return ventaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Venta", "id", "Obtener Venta id", id));
	}

	@Override
	public Venta agregarVenta(int idProducto, int idFactura,Venta venta) {
		
		this.venta = venta;
		
		productoRepository.findById(idProducto).map(producto -> {
			this.venta.setProducto(producto);
			return this.venta;
		}).orElseThrow(() -> new ResourceNotFoundException("Venta", "id", "Producto en agregar Venta", idProducto));
		
		facturaRepository.findById(idFactura).map(factura -> {
			this.venta.setFactura(factura);
			return this.venta;
		}).orElseThrow(() -> new ResourceNotFoundException("Venta", "id", "Factura en agregar Venta", idFactura));
		
		return ventaRepository.save(venta);
	}

	@Override
	public Venta updateVenta(int idProducto, int idFactura,int idVenta, Venta ventaNueva) {
		
		if (!productoRepository.existsById(idProducto)) {
			throw new ResourceNotFoundException("Venta", "id", "Producto en Actualizar Venta", idProducto);
		}
		if (!facturaRepository.existsById(idFactura)) {
			throw new ResourceNotFoundException("Venta", "id", "Factura en Actualizar Venta", idFactura);
		}
		
		return ventaRepository.findById(idVenta).map(venta -> {
			venta.setFechaVenta(ventaNueva.getFechaVenta());
			venta.setValorUnitario(ventaNueva.getValorUnitario());
			return ventaRepository.save(venta);
		}).orElseThrow(() -> new ResourceNotFoundException("Asesor", "id", "Actualizar Venta", idVenta));
	}

	@Override
	public void eliminarVenta(int id) {
		
		Venta venta = ventaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Venta", "id", "Obtener Venta id", id));
		
		ventaRepository.delete(venta);
	}

}
