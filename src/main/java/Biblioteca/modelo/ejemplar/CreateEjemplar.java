package Biblioteca.modelo.ejemplar;

import javax.persistence.EntityManager;

import Biblioteca.negocio.EjemplarBean;

public class CreateEjemplar {
	
	public void create(EjemplarBean ejemplar) {

		EntityManager entityManager = Biblioteca.util.ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(ejemplar);
		entityManager.getTransaction().commit();
		entityManager.close();
	
	}
}
