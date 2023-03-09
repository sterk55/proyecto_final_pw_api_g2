package com.example.demo.uce.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class VehiculoTo extends RepresentationModel<VehiculoTo> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7583564584700271916L;

	private Integer id;
	
	private String placa;
	
	private String modelo;

	private String marca;

	private String anioFablicacion;
	
	private String paisFabricacion;
	
	private Integer cilindraje;
	
	private Double precioVehiculo;
	
	private Double valorDia;
	
	private String disponible;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAnioFablicacion() {
		return anioFablicacion;
	}

	public void setAnioFablicacion(String localDate) {
		this.anioFablicacion = localDate;
	}

	public String getPaisFabricacion() {
		return paisFabricacion;
	}

	public void setPaisFabricacion(String paisFabricacion) {
		this.paisFabricacion = paisFabricacion;
	}

	public Integer getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Double getPrecioVehiculo() {
		return precioVehiculo;
	}

	public void setPrecioVehiculo(Double precioVehiculo) {
		this.precioVehiculo = precioVehiculo;
	}

	public Double getValorDia() {
		return valorDia;
	}

	public void setValorDia(Double valorDia) {
		this.valorDia = valorDia;
	}

	public String getDisponible() {
		return disponible;
	}

	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	
}
