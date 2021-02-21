package com.yeisson.api.facturacion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String tabla;
	private String columna;
	private String descripcion;
	private Object valor;
	
	public ResourceNotFoundException(String tabla, String columna, String descripcion, Object valor) {
		super(String.format("%s inexistente con %s : %s %s", tabla, columna, valor,descripcion));
		this.tabla = tabla;
		this.columna = columna;
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ResourceNotFoundException [tabla=" + tabla + ", columna=" + columna + ", descripcion=" + descripcion
				+ ", valor=" + valor + "]";
	}
	
}