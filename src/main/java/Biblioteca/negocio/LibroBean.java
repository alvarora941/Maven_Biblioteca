package Biblioteca.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//ANOTACIONES DE LA TABLA EN LA BASE DE DATOS
@Entity
@Table(name="libro")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class LibroBean {

	/*
	 *  **************************
	 *  COLUMNAS DE LA BASE DE DATOS
	 *  **************************
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long cod_Libro;

	@Column(name="titulo")
	private String titulo;
	
	@Column(name="ISBN")
	private String ISBN;
	
	@Column(name="editorial")
	private String editorial;
	
	@Column(name="paginas")
	private String páginas;

	
	/*
	 *  **************************
	 *  MANY TO MANY CON LOS AUTORES
	 *  **************************
	 */
	@ManyToMany(mappedBy = "libros")
	private List<AutorBean> autores = new ArrayList<AutorBean>(); 
	
	/*
	 *  **************************
	 *  METODO PARA AÑADIR AUTORES A LOS LIBROS
	 *  **************************
	 */
	public void addAutor(AutorBean autor) {
		if(!autores.contains(autor)) {
			autores.add(autor);
				
			List<LibroBean> libros = autor.getLibros();
			if(!libros.contains(this)) {
				libros.add(this);
			}
		}
	}
	
	/*
	 *  **************************
	 *  ONE TO MANY CON LOS EJEMPLARES
	 *  **************************
	 */
	@OneToMany(mappedBy="libro")
	private List<EjemplarBean> ejemplares = new ArrayList<EjemplarBean>();
	
	/*
	 *  **************************
	 *  METODO PARA AÑADIR INDIVIDUOS A LA ESPECIE
	 *  **************************
	 */
	public void addEjemplar(EjemplarBean ejemplar) {
		
		if(!ejemplares.contains(ejemplar)) {
			
			ejemplares.add(ejemplar);
			
			ejemplar.setLibro(this);
		}
	}
	
	
	
	public List<EjemplarBean> getEjemplares() {
		return ejemplares;
	}



	public void setEjemplares(List<EjemplarBean> ejemplares) {
		this.ejemplares = ejemplares;
	}



	public List<AutorBean> getAutores() {
		return autores;
	}


	public void setAutores(List<AutorBean> autores) {
		this.autores = autores;
	}


	public long getCod_Libro() {
		return cod_Libro;
	}

	public void setCod_Libro(long cod_Libro) {
		this.cod_Libro = cod_Libro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getPáginas() {
		return páginas;
	}

	public void setPáginas(String páginas) {
		this.páginas = páginas;
	}
	
	
}
