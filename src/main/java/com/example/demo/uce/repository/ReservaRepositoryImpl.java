package com.example.demo.uce.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Reserva;

@Repository
@Transactional
public class ReservaRepositoryImpl implements IReservaRespository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crearReserva(Reserva reserva) {
		this.entityManager.persist(reserva);
	}

	@Override
	public Reserva buscaReservaNumero(Integer nReserva) {
		TypedQuery<Reserva> myQuery = this.entityManager.createQuery("SELECT r FROM Reserva r WHERE r.numeroReserva = :nReserva",Reserva.class);
		myQuery.setParameter("nReserva", nReserva);
		if(myQuery.getResultList().isEmpty()) {
			return null;
		}
		return myQuery.getResultList().get(0);
	}

	@Override
	public void actualiza(Reserva reserva) {
		this.entityManager.merge(reserva);
	}

	@Override
	public List<Reserva> reporteReserva(LocalDate fechaInicio, LocalDate fechaFin) {
		TypedQuery<Reserva> myQuery = this.entityManager
				.createQuery("SELECT r FROM Reserva r WHERE r.fechaInicio >= :fechaInicio AND r.fechaFin <= :fechaFin",Reserva.class);
		myQuery.setParameter("fechaInicio", fechaInicio);
		myQuery.setParameter("fechaFin", fechaFin);
		return myQuery.getResultList();
	}
	
}
