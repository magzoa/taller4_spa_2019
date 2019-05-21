package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Departamento;
import py.edu.facitec.model.Producto;
import py.edu.facitec.model.Usuario;

@Repository 
public class DepartamentoDAO extends DAOGenerico<Departamento>{
	
			public DepartamentoDAO() {
		super(Departamento.class);
		
	}
			
	@PersistenceContext  
	private EntityManager em;

			@Override
			protected EntityManager getEntityManager() {
			
				return this.em;
			}
			
	
	
}
