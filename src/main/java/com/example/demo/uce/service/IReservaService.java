package com.example.demo.uce.service;

import java.util.List;

import com.example.demo.uce.repository.modelo.Reserva;
import com.example.demo.uce.service.to.ReservaReporteTo;
import com.example.demo.uce.service.to.ReservaTo;

public interface IReservaService {

	public void crearReserva(Reserva reserva);
	
	public Reserva buscaReservaNumero(Integer nReserva);
	
	public void actualiza(Reserva reserva);
	
	public ReservaTo buscaReservaNumeroTo(Integer nReserva);
	
	public List<ReservaReporteTo> reporteReserva(String fechaInicio, String fechaFin);
	
	
}
