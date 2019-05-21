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

import py.edu.facitec.dao.PedidoDAO;
import py.edu.facitec.model.Pedido;


//Para trabajar con la arquitectura REST
@RestController

@Transactional


@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoDAO pedidoDAO;
	
	
//Indicamos que va responder al verbo GET    indicamos que respondera en formato JSON
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pedido>> getLista(){
		
		
		
		
		
		List<Pedido> pedidos=pedidoDAO.getLista();
		
		
		return new ResponseEntity<>(pedidos, HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
									//indicamos que viene por el cuerpo el json a pasar a pedido
	public ResponseEntity<Pedido> guardar(@RequestBody Pedido pedido){
		
		
		pedidoDAO.guardar(pedido);
		
		
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);	
	}
	
	
					//URL   			VERBO					EL FORMATO A RESPONDER
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> buscarPorId(@PathVariable Integer id){
		
				//Pedido en Java
		Pedido pedido          =pedidoDAO.buscar(id);
		
		
		return new ResponseEntity<Pedido>(pedido,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pedido> eliminar(@PathVariable Integer id){
		
		
		Pedido pedido=pedidoDAO.buscar(id);
		
		
				if(pedido==null){
					
					new ResponseEntity<>(HttpStatus.NOT_FOUND);
					
				}
		
				
				pedidoDAO.eliminar(pedido);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
