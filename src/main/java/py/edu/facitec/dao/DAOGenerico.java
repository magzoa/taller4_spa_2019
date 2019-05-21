package py.edu.facitec.dao;

import java.util.List;

import javax.persistence.EntityManager;import py.edu.facitec.model.Cliente;
					//Clase Generica
		//Que puede recibir un tipo de objeto 
		//en la cabecera
								//Cliente
public abstract class DAOGenerico<T> {

	//Crear una clase a partir del objeto recibido
						//null
			//Cliente cliente
	private Class<T> entityClass;

	
	
	public DAOGenerico(Class<T> entityClass) {
		this.entityClass = entityClass;
		
	}

		//Metodo abstracto
		//La clase hija completara este metodo	
	protected abstract EntityManager getEntityManager();
					//objeto cualquiera
					//objeto cliente
	public void insertar(T entity) {
		
						//Insertar	
		getEntityManager().persist(entity);// Es manipulado por EM
	}

	// METODO PARA ACTUALIZAR
	public void actualizar(T entity) {
						  //actualizar
		
		
		getEntityManager().merge(entity);// actualiza
	}

	// METODO PARA BUSCAR
	public T buscar(Object id) {
		// System.out.println("Entidad: "+getEntityManager().find(entityClass,
		// id));
		return getEntityManager().find(entityClass, id);

	}

	// METODO PARA GUARDAR
	public void guardar(T entity) {
					  //3	
		    	Object id = getEntityManager().getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);    	
		    	
		    	System.out.println("El id en guardar es: "+id);
		    	if(id!=null){
		    	if(buscar(id)==null){   	   	
		        	getEntityManager().persist(entity);
		    	}else{  	   	
		        	getEntityManager().merge(entity);
		    	}
		    	}else{
		    		getEntityManager().persist(entity);
		    	}
	}

	// METODO QUE RETORNA UNA LISTA DE UNA ENTIDAD
	public List<T> getLista() {
		return getEntityManager().createQuery("from " + entityClass.getSimpleName(), entityClass).getResultList();

	}


	// Metodo para eliminar
	public void eliminar(T entity) {

		getEntityManager().remove(getEntityManager().contains(entity) ? entity : getEntityManager().merge(entity)

		);

	}

	
	
	

}

