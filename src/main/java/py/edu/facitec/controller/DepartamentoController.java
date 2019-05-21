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

import py.edu.facitec.dao.DepartamentoDAO;
import py.edu.facitec.model.Departamento;


//Para trabajar con la arquitectura REST
@RestController

@Transactional


@RequestMapping("/departamentos")
public class DepartamentoController {

	@Autowired
	private DepartamentoDAO departamentoDAO;
	
	
//Indicamos que va responder al verbo GET    indicamos que respondera en formato JSON
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Departamento>> getLista(){
		
		
		List<Departamento> departamentos=departamentoDAO.getLista();
		
		
		return new ResponseEntity<>(departamentos, HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
									//indicamos que viene por el cuerpo el json a pasar a departamento
	public ResponseEntity<Departamento> guardar(@RequestBody Departamento departamento){
		
		
		departamentoDAO.guardar(departamento);
		
		
		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);	
	}
	
	
					//URL   			VERBO					EL FORMATO A RESPONDER
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> buscarPorId(@PathVariable Integer id){
		
				//Departamento en Java
		Departamento departamento          =departamentoDAO.buscar(id);
		
		
		return new ResponseEntity<Departamento>(departamento,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Departamento> eliminar(@PathVariable Integer id){
		
		
		Departamento departamento=departamentoDAO.buscar(id);
		
		
				if(departamento==null){
					
					new ResponseEntity<>(HttpStatus.NOT_FOUND);
					
				}
		
				
				departamentoDAO.eliminar(departamento);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
