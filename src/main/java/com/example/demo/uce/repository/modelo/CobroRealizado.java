package com.example.demo.uce.repository.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cobro_realizado")
public class CobroRealizado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "core_id")
	private Integer id;
	
	@Column(name = "core_fecha_cobro")
	private String fechaCobro;
	
	@Column(name = "core_tarjeta")
	private String tarjeta;
	
	@Column(name = "core_valor_subtotal")
	private Double valorSubtotal;
	
	@Column(name = "core_valor_iva")
	private Double valorIva;
	
	@Column(name = "core_valor_pagar")
	private Double valorPagar;
	
	@OneToOne
	@JoinColumn(name = "rese_id")
	private Reserva reserva;

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(String fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Double getValorSubtotal() {
		return valorSubtotal;
	}

	public void setValorSubtotal(Double valorSubtotal) {
		this.valorSubtotal = valorSubtotal;
	}

	public Double getValorIva() {
		return valorIva;
	}

	public void setValorIva(Double valorIva) {
		this.valorIva = valorIva;
	}

	public Double getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(Double valorPagar) {
		this.valorPagar = valorPagar;
	}
	
	

}
