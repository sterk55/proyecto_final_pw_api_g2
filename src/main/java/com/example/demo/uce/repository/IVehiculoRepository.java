package com.example.demo.uce.repository;

import java.util.List;

import com.example.demo.uce.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	
	public void crear(Vehiculo vehiculo);
	
	public List<Vehiculo> buscaVehiculosDisponibles(String marca, String modelo);
	
	public Vehiculo buscaVehiculoPorPlaca(String placa);
	
	public void actualiza(Vehiculo vehiculo); 
	
}
