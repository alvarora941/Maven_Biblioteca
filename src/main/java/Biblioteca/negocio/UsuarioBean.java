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
@Table(name="usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UsuarioBean {

	/*
	 *  **************************
	 *  COLUMNAS DE LA BASE DE DATOS
	 *  **************************
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long cod_Usuario;

	@Column(name="nombre_Usuario")
	private String nombre_Usuario;
	
	@Column(name="direccion_Usuario")
	private String direccion_Usuario;
	
	@Column(name="telefono_Usuario")
	private String telefono_Usuario;

	
	/*
	 *  **************************
	 *  MANY TO MANY CON LOS EJEMPLARES
	 *  **************************
	 */
	@ManyToMany(mappedBy = "usuario")
	private List<EjemplarBean> ejemplares = new ArrayList<EjemplarBean>(); 
	
	/*
	 *  **************************
	 *  METODO PARA AÑADIR EJEMPLARES A LOS USUARIOS
	 *  **************************
	 */
	public void addEjemplar(EjemplarBean ejemplar) {
		if(!ejemplares.contains(ejemplar)) {
			ejemplares.add(ejemplar);
				
			List<UsuarioBean> usuarios = ejemplar.getUsuario();
			if(!usuarios.contains(this)) {
				usuarios.add(this);
			}
		}
	}
	
	
	
	public List<EjemplarBean> getEjemplares() {
		return ejemplares;
	}



	public void setEjemplares(List<EjemplarBean> ejemplares) {
		this.ejemplares = ejemplares;
	}



	public long getCod_Usuario() {
		return cod_Usuario;
	}

	public void setCod_Usuario(long cod_Usuario) {
		this.cod_Usuario = cod_Usuario;
	}

	public String getNombre_Usuario() {
		return nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		this.nombre_Usuario = nombre_Usuario;
	}

	public String getDireccion_Usuario() {
		return direccion_Usuario;
	}

	public void setDireccion_Usuario(String direccion_Usuario) {
		this.direccion_Usuario = direccion_Usuario;
	}

	public String getTelefono_Usuario() {
		return telefono_Usuario;
	}

	public void setTelefono_Usuario(String telefono_Usuario) {
		this.telefono_Usuario = telefono_Usuario;
	}
	
	
}
