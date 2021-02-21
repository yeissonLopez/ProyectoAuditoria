package com.yeisson.api.facturacion.service;

import java.util.List;

import com.yeisson.api.facturacion.models.Cliente;


public interface ClienteService {
	
	public List<Cliente> getClientes();
	public Cliente getByIdCliente(int id);
	public Cliente agregarCliente(Cliente cliente);
	public Cliente updateCliente(int id,Cliente cliente);
	public void eliminarCliente(int id);

}
