package com.example.demo.uce.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.example.demo.uce.controller.ReservaRestFullController;
import com.example.demo.uce.repository.IReservaRespository;
import com.example.demo.uce.repository.modelo.Reserva;
import com.example.demo.uce.service.to.ReservaReporteTo;
import com.example.demo.uce.service.to.ReservaTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ReserveServiceImpl implements IReservaService {
	
	@Autowired
	private IReservaRespository reservaRespository;

	@Override
	public void crearReserva(Reserva reserva) {
		this.reservaRespository.crearReserva(reserva);
	}
	
	@Override
	public Reserva buscaReservaNumero(Integer nReserva) {
		if(this.reservaRespository.buscaReservaNumero(nReserva)==null) {
			return null;
		}
		return this.reservaRespository.buscaReservaNumero(nReserva);
	}

	@Override
	public ReservaTo buscaReservaNumeroTo(Integer nReserva) {
		if(this.reservaRespository.buscaReservaNumero(nReserva)==null) {
			return null;
		}
		return transformaReservaTo(this.reservaRespository.buscaReservaNumero(nReserva));
	}
	
	@Override
	public void actualiza(Reserva reserva) {
		this.reservaRespository.actualiza(reserva);
	}
	
	
	
	@Override
	public List<ReservaReporteTo> reporteReserva(String fechaInicio, String fechaFin) {
		List<Reserva> reservas = this.reservaRespository.reporteReserva(LocalDate.parse(fechaInicio), LocalDate.parse(fechaFin));
		return reservas.stream().map(reserva -> convierteAgrega(reserva)).collect(Collectors.toList());
	}

	private ReservaTo transformaReservaTo(Reserva reserva) {
		ReservaTo aux = new ReservaTo();
		aux.setPlaca(reserva.getVehiculo().getPlaca());
		aux.setModelo(reserva.getVehiculo().getModelo());
		aux.setEstado(reserva.getVehiculo().getDisponible());
		aux.setFecha(reserva.getFechaInicio().toString() + "-" + reserva.getFechaFin());
		aux.setCiCliente(reserva.getCliente().getCedula());
		return aux;
	}
	
	private ReservaReporteTo convierteAgrega(Reserva reserva) {
		ReservaReporteTo reservaReporteTo = new ReservaReporteTo();
		reservaReporteTo.setNumero(reserva.getNumeroReserva());
		reservaReporteTo.setFechaInicio(reserva.getFechaInicio().toString());
		reservaReporteTo.setFechaFin(reserva.getFechaFin().toString());
		reservaReporteTo.setValorTotalPagar(reserva.getValorPagar());
		reservaReporteTo.setDisponible(reserva.getEstado());
		reservaReporteTo.setNombreCliente(reserva.getCliente().getNombre() + " "+ reserva.getCliente().getApellido());
		reservaReporteTo.setCedulaCliente(reserva.getCliente().getCedula());
		reservaReporteTo.setPlaca(reserva.getVehiculo().getPlaca());
		reservaReporteTo.setMarca(reserva.getVehiculo().getMarca());
		reservaReporteTo.setModelo(reserva.getVehiculo().getModelo());
		Link myLink = linkTo(methodOn(ReservaRestFullController.class).getReserva(reservaReporteTo.getNumero())).withRel("link");
		reservaReporteTo.add(myLink);
		return reservaReporteTo;
	}

}
