package Biblioteca.inicio;

import Biblioteca.modelo.autor.CreateAutor;
import Biblioteca.modelo.ejemplar.CreateEjemplar;
import Biblioteca.modelo.libro.CreateLibro;
import Biblioteca.modelo.usuario.CreateUsuario;
import Biblioteca.negocio.AutorBean;
import Biblioteca.negocio.EjemplarBean;
import Biblioteca.negocio.LibroBean;
import Biblioteca.negocio.UsuarioBean;

public class Start {

	public static void main(String arg[]) {
		
		/*
		 * ********************************
		 * C R E A N D O    O B J E T O S
		 * ********************************
		 */
		AutorBean alvaro = new AutorBean();
		alvaro.setNombre_Autor("Alvaro");
		
		LibroBean libro1 = new LibroBean();
		libro1.setEditorial("Grill");
		libro1.setISBN("123456789");
		libro1.setPáginas("500");
		libro1.setTitulo("Alicia y el pais de las maravillas");
		
		LibroBean libro2 = new LibroBean();
		libro2.setEditorial("Maw");
		libro2.setISBN("987654321");
		libro2.setPáginas("800");
		libro2.setTitulo("Harry Potter");
		
		
		EjemplarBean ejemplar1 = new EjemplarBean();
		ejemplar1.setLocalizacion("Oviedo");
		
		EjemplarBean ejemplar2 = new EjemplarBean();
		ejemplar2.setLocalizacion("Gijon");
		
		UsuarioBean usuario1 = new UsuarioBean();
		usuario1.setNombre_Usuario("Manolo");
		usuario1.setTelefono_Usuario("666666666");
		usuario1.setDireccion_Usuario("Calle Los abedules");
		
		UsuarioBean usuario2 = new UsuarioBean();
		usuario2.setNombre_Usuario("Pepe");
		usuario2.setTelefono_Usuario("111111111");
		usuario2.setDireccion_Usuario("Calle Los Rosales");
		
		/*
		 * **************************************************
		 * A Ñ A D I E N D O    I N F O R M A C I Ó N
		 * **************************************************
		 */	
		
		libro1.addAutor(alvaro);
		libro2.addAutor(alvaro);
		
		libro1.addEjemplar(ejemplar1);
		libro2.addEjemplar(ejemplar2);
		
		usuario1.addEjemplar(ejemplar1);
		usuario2.addEjemplar(ejemplar2);
		
		
		/*
		 * **************************************************
		 * P E R S I S T I E N D O    L O S     D A T O S
		 * **************************************************
		 */
		CreateLibro createLibro = new CreateLibro();
		createLibro.create(libro1);
		createLibro.create(libro2);
		
		CreateAutor createAutor = new CreateAutor();
		createAutor.create(alvaro);
		CreateUsuario createUsuario = new CreateUsuario();
		createUsuario.create(usuario1);
		createUsuario.create(usuario2);

		CreateEjemplar createEjemplar = new CreateEjemplar();
		createEjemplar.create(ejemplar1);
		createEjemplar.create(ejemplar2);

		/*
		* CAMBIANDO DATOS
		+/
		

		
		

	
		
	}
	
	
}
