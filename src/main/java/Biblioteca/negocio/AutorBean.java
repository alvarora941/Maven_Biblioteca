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
import javax.persistence.Table;


//ANOTACIONES DE LA TABLA EN LA BASE DE DATOS
@Entity
@Table(name="autor")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AutorBean {

	
	/*
	 *  **************************
	 *  COLUMNAS DE LA BASE DE DATOS
	 *  **************************
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long cod_Autor;

	@Column(name="nombre_Autor")
	private String nombre_Autor;

	/*
	 *  **************************
	 *  MANY TO MANY CON LOS LIBROS
	 *  **************************
	 */
	@ManyToMany
	private List<LibroBean> libros = new ArrayList<LibroBean>();
	
	
	
	public List<LibroBean> getLibros() {
		return libros;
	}

	public void setLibros(List<LibroBean> libros) {
		this.libros = libros;
	}

	public long getCod_Autor() {
		return cod_Autor;
	}

	public void setCod_Autor(long cod_Autor) {
		this.cod_Autor = cod_Autor;
	}

	public String getNombre_Autor() {
		return nombre_Autor;
	}

	public void setNombre_Autor(String nombre_Autor) {
		this.nombre_Autor = nombre_Autor;
	}
	
	
}
