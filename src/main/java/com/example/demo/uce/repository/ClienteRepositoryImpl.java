package com.example.demo.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void registrarCliente(Cliente cliente) {
		this.em.persist(cliente);
	}

	@Override
	public Cliente buscarClienteCedula(String idCliente) {
		TypedQuery<Cliente> myQuery = this.em.createQuery("SELECT c FROM Cliente c WHERE c.cedula = :idCliente",Cliente.class);
		myQuery.setParameter("idCliente", idCliente);
		if(myQuery.getResultList().isEmpty()) {
			return null;
		}
		return myQuery.getResultList().get(0);
	}

	@Override
	public List<Cliente> listarClientes() {
		TypedQuery<Cliente> myQuery = this.em.createQuery("SELECT c FROM Cliente c",Cliente.class);
		return myQuery.getResultList();
	}

	@Override
	public void actualizar(Cliente cliente) {
		this.em.merge(cliente);
	}
	
}
