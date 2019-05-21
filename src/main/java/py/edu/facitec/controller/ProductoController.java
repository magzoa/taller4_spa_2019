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

import py.edu.facitec.dao.ProductoDAO;
import py.edu.facitec.model.Producto;


//Para trabajar con la arquitectura REST
@RestController

@Transactional


@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoDAO productoDAO;
	
	
//Indicamos que va responder al verbo GET    indicamos que respondera en formato JSON
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> getLista(){
		
		
		List<Producto> productos=productoDAO.getLista();
		
		
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
									//indicamos que viene por el cuerpo el json a pasar a producto
	public ResponseEntity<Producto> guardar(@RequestBody Producto producto){
		
		
		productoDAO.guardar(producto);
		
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);	
	}
	
	
					//URL   			VERBO					EL FORMATO A RESPONDER
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> buscarPorId(@PathVariable Integer id){
		
				//Producto en Java
		Producto producto          =productoDAO.buscar(id);
		
		
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> eliminar(@PathVariable Integer id){
		
		
		Producto producto=productoDAO.buscar(id);
		
		
				if(producto==null){
					
					new ResponseEntity<>(HttpStatus.NOT_FOUND);
					
				}
		
				
				productoDAO.eliminar(producto);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
