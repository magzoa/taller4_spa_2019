package py.edu.facitec.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import py.edu.facitec.model.Usuario;

@Repository 
public class UsuarioDAO extends DAOGenerico<Usuario>{
	
			public UsuarioDAO() {
		super(Usuario.class);
		
	}
			
	@PersistenceContext  
	private EntityManager em;

			@Override
			protected EntityManager getEntityManager() {
			
				return this.em;
			}
			
			public Usuario busquedaUsuario(String login) {
				
				List<Usuario> lisRetorno = new ArrayList<Usuario>();
				Usuario retorno = null;
				lisRetorno = getEntityManager().createQuery(
						"select p from Usuario p WHERE p.login='" + login + "'").getResultList();
				if (!lisRetorno.isEmpty()) {
					retorno = lisRetorno.get(0);
				}
				return retorno;
			}
	
}
