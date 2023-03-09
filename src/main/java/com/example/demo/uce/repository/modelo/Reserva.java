package com.example.demo.uce.repository.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "rese_id")
	private Integer id;
	
	@Column(name = "rese_numero_reserva")
	private Integer numeroReserva;
	
	@Column(name = "rese_fecha_inicio")
	private LocalDate fechaInicio;
	
	@Column(name = "rese_fecha_fin")
	private LocalDate fechaFin;
	
	@Column(name = "rese_estado")
	private String estado;//Generado-Ejecutado
	
	@Column(name = "rese_valor_pagar")
	private Double valorPagar;//iva+subtotal
	
	@ManyToOne
	@JoinColumn(name = "clie_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "vehi_id")
	private Vehiculo vehiculo;
	
	@OneToOne(mappedBy = "reserva", cascade = CascadeType.ALL)
	private CobroRealizado cobroRealizado;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public CobroRealizado getCobroRealizado() {
		return cobroRealizado;
	}

	public void setCobroRealizado(CobroRealizado cobroRealizado) {
		this.cobroRealizado = cobroRealizado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(Integer numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(Double valorPagar) {
		this.valorPagar = valorPagar;
	}
	
	
	

}
