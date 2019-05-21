package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Cliente;
import py.edu.facitec.model.Gerente;

@Repository 
public class GerenteDAO extends DAOGenerico<Gerente>{
	
			public GerenteDAO() {
		super(Gerente.class);
		
	}
			
	@PersistenceContext  
	private EntityManager em;

			@Override
			protected EntityManager getEntityManager() {
			
				return this.em;
			}
			
	
	
}
