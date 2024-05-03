package Biblioteca.modelo.libro;

import javax.persistence.EntityManager;

import Biblioteca.negocio.LibroBean;


public class CreateLibro {

	public void create(LibroBean libro) {

		EntityManager entityManager = Biblioteca.util.ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(libro);
		entityManager.getTransaction().commit();
		entityManager.close();
	
	}
}
