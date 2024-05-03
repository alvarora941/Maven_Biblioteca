package Biblioteca.modelo.autor;

import javax.persistence.EntityManager;

import Biblioteca.negocio.AutorBean;


public class CreateAutor {

	public void create(AutorBean autor) {

		EntityManager entityManager = Biblioteca.util.ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(autor);
		entityManager.getTransaction().commit();
		entityManager.close();
	
	}
}
