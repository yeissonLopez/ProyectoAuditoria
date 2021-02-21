package com.yeisson.api.facturacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeisson.api.facturacion.exception.ResourceNotFoundException;
import com.yeisson.api.facturacion.models.Cliente;
import com.yeisson.api.facturacion.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente getByIdCliente(int id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("cliente", "id", "Obtener Cliente id", id));
	}

	@Override
	public Cliente agregarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente updateCliente(int idCliente, Cliente clienteNuevo) {
		return clienteRepository.findById(idCliente).
				map(cliente ->{
					cliente.setNombre(clienteNuevo.getNombre());
					cliente.setApellido(clienteNuevo.getApellido());
					cliente.setGenero(clienteNuevo.getGenero());
					cliente.setEmail(clienteNuevo.getEmail());
					cliente.setTelefono(clienteNuevo.getTelefono());
					cliente.setDireccion(clienteNuevo.getDireccion());
					cliente.setFechaNacimiento(clienteNuevo.getFechaNacimiento());
					return clienteRepository.save(cliente);
				}).orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", "Actualizar cliente", idCliente));
	}

	@Override
	public void eliminarCliente(int id) {
		
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("cliente", "id", "Obtener Cliente id", id));
		
		clienteRepository.delete(cliente);
	}

}
