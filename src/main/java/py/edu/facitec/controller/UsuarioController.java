package py.edu.facitec.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.dao.UsuarioDAO;
import py.edu.facitec.model.Usuario;


//Para trabajar con la arquitectura REST
@RestController

@Transactional


@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	
//Indicamos que va responder al verbo GET    indicamos que respondera en formato JSON
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> getLista(){
		
		
		List<Usuario> usuarios=usuarioDAO.getLista();
		
		
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
									//indicamos que viene por el cuerpo el json a pasar a usuario
	public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario){
		
		
		usuarioDAO.guardar(usuario);
		
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);	
	}
	
	
					//URL   			VERBO					EL FORMATO A RESPONDER
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id){
		
				//Usuario en Java
		Usuario usuario          =usuarioDAO.buscar(id);
		
		
		return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
		
	}
	
												//Expreción regular, cualquier caracter con más de una aparición
																										//El carácter asterisco "*" se usa para tipos de medios grupo en rangos, con "* / *" indica todos los tipos de medios de comunicación y "tipo / *", indicando todos los subtipos de ese tipo. 
	
	@RequestMapping( headers="Accept=*/*",value="/{login:.+}",
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.DELETE)
	public ResponseEntity<Usuario> eliminar(@PathVariable String login){
		
		
		System.out.println(login);
		
		Usuario usuario=usuarioDAO.buscar(login);
		
	
		
				if(usuario==null){
					
					new ResponseEntity<>(HttpStatus.NOT_FOUND);
					
				}
		
				
				usuarioDAO.eliminar(usuario);
		
		
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
