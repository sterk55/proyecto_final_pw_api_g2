package com.example.demo.uce.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.uce.repository.modelo.Reserva;

public interface IReservaRespository {
	
	public void crearReserva(Reserva reserva);
	
	public Reserva buscaReservaNumero(Integer nReserva);
	
	public void actualiza(Reserva reserva);
	
	public List<Reserva> reporteReserva(LocalDate fechaInicio, LocalDate fechaFin);
	
}
