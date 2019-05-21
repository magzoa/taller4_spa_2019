package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Cliente;

@Repository //Trabajar con el EntityManager
public class ClienteDAO extends DAOGenerico<Cliente>{
	
			public ClienteDAO() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}
	//Manejador de la conexion para cada entidad
	@PersistenceContext  //Indicamos la unidad de persistencia
	private EntityManager em;

			@Override
			protected EntityManager getEntityManager() {
			
				return this.em;
			}
	
	
	//public void save(Cliente cliente){
		 //método para insertar datos
		//convierte el objeto recibido en una sentencia sql
	//	em.persist(cliente);
		
		
	//}
	

}
