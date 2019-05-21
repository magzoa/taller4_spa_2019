package py.edu.facitec.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Pedido;
import py.edu.facitec.model.Producto;
import py.edu.facitec.model.Usuario;

@Repository 
public class PedidoDAO extends DAOGenerico<Pedido>{
	
			public PedidoDAO() {
		super(Pedido.class);
		
	}
			
	@PersistenceContext  
	private EntityManager em;

			@Override
			protected EntityManager getEntityManager() {
			
				return this.em;
			}
			
	
	
}
