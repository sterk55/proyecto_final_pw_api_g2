package com.example.demo.uce.service;

import java.util.List;

import com.example.demo.uce.repository.modelo.Cliente;
import com.example.demo.uce.service.to.ClienteAuxTo;
import com.example.demo.uce.service.to.ClienteTo;

public interface IClienteService {

	public void registrarCliente(Cliente cliente);
	
	public Cliente buscarClienteCedula(String idCliente);
	
	public ClienteAuxTo buscarClienteToCedula(String idCliente);
	
	public List<ClienteTo> listaClientesVIP();
	
	public void actualizarCliente(Cliente cliente);
	
}
