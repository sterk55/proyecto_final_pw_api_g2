package com.example.demo.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.example.demo.uce.repository.modelo.Vehiculo;

@Repository
@Transactional
public class VehiculoRespositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void crear(Vehiculo vehiculo) {
		this.entityManager.persist(vehiculo);	
	}

	@Override
	public List<Vehiculo> buscaVehiculosDisponibles(String marca, String modelo) {
		TypedQuery<Vehiculo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vehiculo v WHERE v.marca =:marca AND v.modelo =:modelo", Vehiculo.class);
		myQuery.setParameter("marca", marca);
		myQuery.setParameter("modelo", modelo);
		return myQuery.getResultList();
	}

	@Override
	public Vehiculo buscaVehiculoPorPlaca(String placa) {
		TypedQuery<Vehiculo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vehiculo v WHERE v.placa =:placa", Vehiculo.class);
		myQuery.setParameter("placa", placa);
		if(myQuery.getResultList().isEmpty()) {
			return null;
		}
		return myQuery.getResultList().get(0);
	}

	@Override
	public void actualiza(Vehiculo vehiculo) {
		this.entityManager.persist(vehiculo);
	}


}
