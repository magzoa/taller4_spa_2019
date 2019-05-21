package py.edu.facitec.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {
	
	@Id
//No puede ser autogenerado	
	private String login;
	
	//Definiendo atributo como unico
	@Column(unique=true)
	private String name;
	
	
	private String password;
	
	@JsonBackReference(value="departamento_usuario")
	@ManyToOne
	private Departamento departamento;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario")
	private List<Pedido> pedidos;
	
	
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", name=" + name + ", password=" + password + "]";
	}
	
	

}
