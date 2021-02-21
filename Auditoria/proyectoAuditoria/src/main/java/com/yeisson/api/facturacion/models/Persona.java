package com.yeisson.api.facturacion.models;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona {
	
	private String nombre;
	private String apellido;
	private String genero;
	private String email;
	private String telefono;
	private String direccion;
	
	public Persona() {
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [" + ", nombre=" + nombre + ", apellido=" + apellido + ", genero="
				+ genero + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}
	
}
