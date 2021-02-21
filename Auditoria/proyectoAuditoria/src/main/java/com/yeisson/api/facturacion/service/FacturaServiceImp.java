package com.yeisson.api.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeisson.api.facturacion.exception.ResourceNotFoundException;
//import com.yeisson.api.facturacion.models.Cliente;
//import com.yeisson.api.facturacion.models.Empleado;
import com.yeisson.api.facturacion.models.Factura;
import com.yeisson.api.facturacion.repository.ClienteRepository;
import com.yeisson.api.facturacion.repository.EmpleadoRepository;
import com.yeisson.api.facturacion.repository.FacturaRepository;

@Service
public class FacturaServiceImp implements FacturaService {
	
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	private Factura factura;

	@Override
	public List<Factura> getFacturas() {
		return facturaRepository.findAll();
	}

	@Override
	public Factura getByIdFactura(int id) {
		return facturaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("factura", "id", "Obtener factura id", id));
	}

	@Override
	public Factura agregarFactura(int idEmpleado,int idCliente, Factura factura) {
		this.factura = factura;
		
		empleadoRepository.findById(idEmpleado).map(empleado ->{
			this.factura.setEmpleado(empleado);
			return this.factura;
		}).orElseThrow(() -> new ResourceNotFoundException("empleado", "id", "Obtener Empleado id para factura ", idEmpleado));
		
		clienteRepository.findById(idCliente).map(cliente ->{
			this.factura.setCliente(cliente);
			return this.factura;
		}).orElseThrow(() -> new ResourceNotFoundException("cliente", "id", "Obtener Cliente id para factura", idCliente));
		
		return facturaRepository.save(factura);
	}

	@Override
	public Factura updateFactura(int idCliente, int idEmpleado, int idFactura, Factura facturaNueva) {
		
		if (!clienteRepository.existsById(idCliente)) {
			throw new ResourceNotFoundException("Cliente", "id", "No existe Cliente para actualizar Factura", idCliente);
		}
		if (!empleadoRepository.existsById(idEmpleado)) {
			throw new ResourceNotFoundException("Empleado", "id", "No existe Empleado para actualizar Factura", idEmpleado);
		}
		//Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new ResourceNotFoundException("cliente", "id", "Obtener Cliente id", idCliente));
		//Empleado empleado = empleadoRepository.findById(idEmpleado).orElseThrow(() -> new ResourceNotFoundException("empleado", "id", "Obtener Empleado id", idEmpleado));
		
		return facturaRepository.findById(idFactura).map(factura ->{
			factura.setFechaFactura(facturaNueva.getFechaFactura());
			factura.setValor(facturaNueva.getValor());
			factura.setIva(facturaNueva.getIva());
			factura.setValorTotal(facturaNueva.getValorTotal());
			return facturaRepository.save(factura);
		}).orElseThrow(() -> new ResourceNotFoundException("Factura", "id","Actualizar Factura ", idFactura));
	}

	@Override
	public void eliminarFactura(int id) {
		Factura factura = facturaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("factura", "id", "Obtener factura id", id));
		
		facturaRepository.delete(factura);
	}

}
