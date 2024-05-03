package Biblioteca.modelo.usuario;

import javax.persistence.EntityManager;

import Biblioteca.negocio.UsuarioBean;


public class CreateUsuario {

	public void create(UsuarioBean usuario) {

		EntityManager entityManager = Biblioteca.util.ConnectionEntityManagerFactory.getEntityManager().createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();
	
	}
}
