package com.example.demo.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.repository.modelo.Vehiculo;
import com.example.demo.uce.service.IVehiculoService;
import com.example.demo.uce.service.to.ReservaAux;
import com.example.demo.uce.service.to.VehiculoTo;

@RestController
@RequestMapping("/vehiculos")
@CrossOrigin(origins="http://localhost:8080/",methods = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET, RequestMethod.DELETE})
public class VehiculoRestFullController {

	@Autowired
	private IVehiculoService vehiculoService;
	
	@PutMapping(path = "/retiro")//?nReserva=xxxx
	
	public String retiraVehiculoReservado(@RequestParam("nReserva") Integer nReserva) {
		String msj = "vehiculo retirado correctamente";
		try {
			this.vehiculoService.retiraVehiculoReservado(nReserva);
		} catch (Exception e) {
			msj = "Error al retirar el vehículo" + e;
		}
		return msj;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VehiculoTo> buscaVehiculosDisponibles(@RequestParam("marca") String marca,
			@RequestParam("modelo") String modelo) {
		List<VehiculoTo> lista = this.vehiculoService.buscaVehiculosDisponibles(marca, modelo);
		return lista;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public String crear(@RequestBody Vehiculo vehiculo) {
		String msj = "Vehiculo ingresado correctamente";
		try {
			this.vehiculoService.crear(vehiculo);
		} catch (Exception e) {
			msj = "Error al ingresar el vehículo" + e;
		}
		return msj;
	}

	@GetMapping(path = "/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoTo> buscaVehiculoPorPlaca(@PathVariable("placa") String placa) {
		return ResponseEntity.ok(this.vehiculoService.buscaVehiculoPorPlaca(placa));
	}
	
	@PostMapping(path = "/reserva", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> reservaVehiculo(@RequestBody ReservaAux reserva) {
		return ResponseEntity
				.ok(this.vehiculoService.reservaVehiculo(reserva.getPlaca(), reserva.getCiCliente(), reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getNumeroTarjeta()));
	}
	
	@GetMapping(path = "/busqueda",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> buscaVehiculoPorPlacaFecha(@RequestParam("placa") String placa, @RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin) {
		return ResponseEntity
				.ok(this.vehiculoService.compruebaVehiculoPorPlacaFecha(placa, fechaInicio, fechaFin));
	}
	
	
}
