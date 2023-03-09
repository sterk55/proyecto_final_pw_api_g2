package com.example.demo.uce.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class ReservaTo extends RepresentationModel<ReservaTo> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8774359433941464313L;

	private String placa;
	
	private String modelo;
	
	private String estado;
	
	private String fecha;
	
	private String ciCliente;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCiCliente() {
		return ciCliente;
	}

	public void setCiCliente(String ciCliente) {
		this.ciCliente = ciCliente;
	}
	
	
	
}
