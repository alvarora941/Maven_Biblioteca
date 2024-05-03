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
import javax.persistence.ManyToOne;
import javax.persistence.Table;


//ANOTACIONES DE LA TABLA EN LA BASE DE DATOS
@Entity
@Table(name="ejemplar")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class EjemplarBean {

	/*
	 *  **************************
	 *  COLUMNAS DE LA BASE DE DATOS
	 *  **************************
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long codigo_Ejemplar;

	@Column(name="localizacion")
	private String localizacion;

	
	/*
	 *  **************************
	 *  MANY TO ONE CON LOS LIBROS
	 *  **************************
	 */
	@ManyToOne
	private LibroBean libro;
	
	
	/*
	 *  **************************
	 *  MANY TO MANY CON LOS USUARIOS
	 *  **************************
	 */
	@ManyToMany
	private List<UsuarioBean> usuario = new ArrayList<UsuarioBean>();
	


	public void setCodigo_Ejemplar(long codigo_Ejemplar) {
		this.codigo_Ejemplar = codigo_Ejemplar;
	}

	public List<UsuarioBean> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<UsuarioBean> usuario) {
		this.usuario = usuario;
	}

	public LibroBean getLibro() {
		return libro;
	}

	public void setLibro(LibroBean libro) {
		this.libro = libro;
	}

	public long getCodigo_Ejemplar() {
		return codigo_Ejemplar;
	}

	public void setCod_Ejemplar(long codigo_Ejemplar) {
		this.codigo_Ejemplar = codigo_Ejemplar;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
	
}
