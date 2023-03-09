package com.example.demo.uce.service;

import java.util.List;

import com.example.demo.uce.repository.modelo.Vehiculo;
import com.example.demo.uce.service.to.VehiculoTo;

public interface IVehiculoService {

	public void crear(Vehiculo vehiculo);
	
	public List<VehiculoTo> buscaVehiculosDisponibles(String marca, String modelo);
	
	public VehiculoTo buscaVehiculoPorPlaca(String placa);
	
	public Vehiculo buscaVehiculoPlaca(String placa);
	
	public void actualiza(Vehiculo vehiculo);
	
	public String reservaVehiculo(String placa, String cedula, String fechaInicio, String fechaFin, String numeroTarjeta);
	
	public String compruebaVehiculoPorPlacaFecha(String placa, String fInicio, String fFin);

	public void retiraVehiculoReservado(Integer nReserva);
}
