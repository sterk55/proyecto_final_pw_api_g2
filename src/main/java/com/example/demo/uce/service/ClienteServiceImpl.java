package com.example.demo.uce.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.ClienteRepositoryImpl;
import com.example.demo.uce.repository.modelo.Cliente;
import com.example.demo.uce.repository.modelo.Reserva;
import com.example.demo.uce.service.to.ClienteAuxTo;
import com.example.demo.uce.service.to.ClienteTo;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteRepositoryImpl clienteRepository;
	
	@Override
	public void registrarCliente(Cliente cliente) {
		this.clienteRepository.registrarCliente(cliente);
	}

	@Override
	public ClienteAuxTo buscarClienteToCedula(String idCliente) {
		if(this.clienteRepository.buscarClienteCedula(idCliente)==null) {
			return null;
		}
		return convertirCliAuxTo(this.clienteRepository.buscarClienteCedula(idCliente));
	}
	
	@Override
	public Cliente buscarClienteCedula(String idCliente) {
		if(this.clienteRepository.buscarClienteCedula(idCliente)==null) {
			return null;
		}
		return this.clienteRepository.buscarClienteCedula(idCliente);
	}
	
	@Override
	public List<ClienteTo> listaClientesVIP() {
		List<Cliente> lstClientes = this.clienteRepository.listarClientes();
		List<ClienteTo> lstClientesTo = new ArrayList<>();
		for(Cliente c : lstClientes) {
			lstClientesTo.add(convertirClienteTo(c));
		}
		lstClientesTo.sort(Comparator.comparing(ClienteTo::getValorTotal).reversed());
		return lstClientesTo;
	}
	
	private ClienteAuxTo convertirCliAuxTo(Cliente cliente) {
		ClienteAuxTo clAuxTo = new ClienteAuxTo();
		clAuxTo.setId(cliente.getId());
		clAuxTo.setCedula(cliente.getCedula());
		clAuxTo.setNombre(cliente.getNombre());
		clAuxTo.setApellido(cliente.getApellido());
		clAuxTo.setFechaNacimiento(cliente.getFechaNacimiento());
		clAuxTo.setGenero(cliente.getGenero());
		clAuxTo.setTipoRegistro(cliente.getTipoRegistro());
		return clAuxTo;
	}
	
	private ClienteTo convertirClienteTo(Cliente cliente) {
		ClienteTo clTo = new ClienteTo();
		clTo.setCedula(cliente.getCedula());
		clTo.setNombre(cliente.getNombre());
		clTo.setApellido(cliente.getApellido());
		clTo.setValorIva(valorIva(cliente.getReservas()));
		clTo.setValorTotal(valorTotal(cliente.getReservas()));
		return clTo;
	}
	
	private Double valorIva(List<Reserva> reservasCliente) {
		Double valorI = 0.0;
		for(Reserva reserva : reservasCliente) {
			System.out.println(reserva);
			valorI += reserva.getCobroRealizado().getValorIva();
		}
		return valorI;
	}

	private Double valorTotal(List<Reserva> reservasCliente) {
		Double valorT = 0.0;
		for(Reserva reserva : reservasCliente) {
			valorT += reserva.getValorPagar();
		}
		return valorT;
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		this.clienteRepository.actualizar(cliente);
	}
	
}
