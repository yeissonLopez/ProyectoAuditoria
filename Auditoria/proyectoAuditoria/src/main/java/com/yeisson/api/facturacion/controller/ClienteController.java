package com.yeisson.api.facturacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yeisson.api.facturacion.models.Cliente;
import com.yeisson.api.facturacion.service.ClienteService;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/cliente")
	public Cliente addCliente(@Validated @RequestBody Cliente cliente) {
		return clienteService.agregarCliente(cliente);
	}
	
	@DeleteMapping("/cliente/{idCliente}")
	public void deleteCliente(@PathVariable(value = "idCliente") Integer idCliente) {
		clienteService.eliminarCliente(idCliente);
	}
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes() {
		return clienteService.getClientes();
	}
	
	@GetMapping("/cliente/{idCliente}")
	public Cliente getClienteById(@PathVariable(value = "idCliente") Integer idCliente) {
		return clienteService.getByIdCliente(idCliente);
	}
	
	@PutMapping("/cliente/{idCliente}")
	public Cliente updateCliente(@PathVariable (value = "idCliente")int idCliente,
								 @Validated @RequestBody Cliente cliente) {
		return clienteService.updateCliente(idCliente, cliente);
	}
}
