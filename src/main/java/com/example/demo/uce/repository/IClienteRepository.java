package com.example.demo.uce.repository;

import java.util.List;

import com.example.demo.uce.repository.modelo.Cliente;

public interface IClienteRepository {

	public void registrarCliente(Cliente cliente);
	
	public Cliente buscarClienteCedula(String idCliente);
	
	public List<Cliente> listarClientes();
	
	public void actualizar(Cliente cliente);

void insertarCliente(Cliente cliente);
Cliente buscarCliente(Integer id);
void actualizarCliente(Cliente cliente);
void borrarCliente(Integer id);

	Cliente buscarClientePorApellido(String apellido);

}
