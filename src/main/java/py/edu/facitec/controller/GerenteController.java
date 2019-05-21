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

import py.edu.facitec.dao.GerenteDAO;
import py.edu.facitec.model.Gerente;


//Para trabajar con la arquitectura REST
@RestController

@Transactional


@RequestMapping("/gerentes")
public class GerenteController {

	@Autowired
	private GerenteDAO gerenteDAO;
	
	
//Indicamos que va responder al verbo GET    indicamos que respondera en formato JSON
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Gerente>> getLista(){
		
		
		List<Gerente> gerentes=gerenteDAO.getLista();
		
		
		return new ResponseEntity<>(gerentes, HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
									//indicamos que viene por el cuerpo el json a pasar a gerente
	public ResponseEntity<Gerente> guardar(@RequestBody Gerente gerente){
		
		
		gerenteDAO.guardar(gerente);
		
		
		return new ResponseEntity<Gerente>(gerente, HttpStatus.OK);	
	}
	
	
					//URL   			VERBO					EL FORMATO A RESPONDER
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> buscarPorId(@PathVariable Integer id){
		
				//Gerente en Java
		Gerente gerente          =gerenteDAO.buscar(id);
		
		
		return new ResponseEntity<Gerente>(gerente,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gerente> eliminar(@PathVariable Integer id){
		
		
		Gerente gerente=gerenteDAO.buscar(id);
		
		
				if(gerente==null){
					
					new ResponseEntity<>(HttpStatus.NOT_FOUND);
					
				}
		
				
				gerenteDAO.eliminar(gerente);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
