package com.example.demo.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.uce.repository.modelo.Cliente;
import com.example.demo.uce.service.IClienteService;
import com.example.demo.uce.service.to.ClienteAuxTo;
import com.example.demo.uce.service.to.ClienteTo;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("http://localhost:8080/")
public class ClienteRestFulController {
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public String crear(@RequestBody Cliente cliente) {
		String msj = "Cliente ingresado correctamente";
		try {
			this.clienteService.registrarCliente(cliente);
		} catch (Exception e) {
			msj = "Error al ingresar el Cliente" + e;
		}
		return msj;
	}
	
/*	@GetMapping(path = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteAuxTo> buscarClienteCedula(@PathVariable("cedula") String cedula){
		return ResponseEntity.ok(this.clienteService.buscarClienteToCedula(cedula));
	}*/

	@GetMapping(path = "/{apellido}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClienteTo> buscarClienteCedula(@PathVariable("apellido") String apellido){
		return ResponseEntity.ok(this.clienteService.buscarClientePorApellido(apellido));
	}
	
	@GetMapping(path = "/vip" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClienteTo>> listarClientesVip(){
		return ResponseEntity.ok(this.clienteService.listaClientesVIP());
	}


	@PutMapping(path ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void actualizarCliente(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		cliente.setId(id);
		this.clienteService.actualizarCliente(cliente);
	}

	@DeleteMapping(path ="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminarCliente(@PathVariable("id") Integer id) {
		this.clienteService.borrarCliente(id);
	}
}
