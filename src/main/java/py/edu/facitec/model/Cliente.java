package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	//Se puede almacenar hasta 50 caracteres
	@Column(length=50,nullable=false)
	
	private String nombre;
	
	private String correo;
	
	//Atributo que no se persistira en la bd
	
	@Transient
	private String auxiliar;
	
	
	//Aplicando la Asociación bidireccional
	
	//Donde hay  solo el 1 se crea la lista
	//se utiliza la propiedad mappedBy que es el objeto de la otra entidad asociada.
	
	
	@JsonIgnore
	@OneToMany(mappedBy="cliente")
	private List<Pedido> pedidos;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", correo=" + correo + "]";
	}
	
	
	
	

}
