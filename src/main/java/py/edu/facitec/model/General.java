package py.edu.facitec.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass //Indicamos que sera la clase padre
	              //de nuestras entidades a persistir
		//No se creara una tabla de esta clase
public abstract class General {
	
	@Id					//Utiliza el generador de la tabla en la bd
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
	
}
