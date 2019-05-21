package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Departamento extends General{

	
	private String descripcion;
	
	
	//Relacion de uno a uno
	//Se crea un objeto de la otra entidad en relacion en cada clase
	
	
	//en cualquiera de las clases se puede utilizar la propiedad mappedBy
	
	@JsonIgnore
	@OneToOne(mappedBy="departamento")
	private Gerente gerente;
	
	@JsonManagedReference(value="departamento_usuario")
	@OneToMany(mappedBy="departamento")
	private List<Usuario> usuarios;
	
	
	public Departamento() {
	descripcion="";
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Gerente getGerente() {
		return gerente;
	}


	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
	
}
