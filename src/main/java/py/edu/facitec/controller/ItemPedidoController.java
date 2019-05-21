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

import py.edu.facitec.dao.ItemPedidoDAO;
import py.edu.facitec.model.ItemPedido;


//Para trabajar con la arquitectura REST
@RestController

@Transactional


@RequestMapping("/item_pedido")
public class ItemPedidoController {

	@Autowired
	private ItemPedidoDAO itemPedidoDAO;
	
	
//Indicamos que va responder al verbo GET    indicamos que respondera en formato JSON
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ItemPedido>> getLista(){
		
		
		List<ItemPedido> itemPedidos=itemPedidoDAO.getLista();
		
		
		return new ResponseEntity<>(itemPedidos, HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
									//indicamos que viene por el cuerpo el json a pasar a itemPedido
	public ResponseEntity<ItemPedido> guardar(@RequestBody ItemPedido itemPedido){
		
		
		itemPedidoDAO.guardar(itemPedido);
		
		
		return new ResponseEntity<ItemPedido>(itemPedido, HttpStatus.OK);	
	}
	
	
					//URL   			VERBO					EL FORMATO A RESPONDER
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> buscarPorId(@PathVariable Integer id){
		
				//ItemPedido en Java
		ItemPedido itemPedido          =itemPedidoDAO.buscar(id);
		
		
		return new ResponseEntity<ItemPedido>(itemPedido,HttpStatus.OK);
		
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemPedido> eliminar(@PathVariable Integer id){
		
		
		ItemPedido itemPedido=itemPedidoDAO.buscar(id);
		
		
				if(itemPedido==null){
					
					new ResponseEntity<>(HttpStatus.NOT_FOUND);
					
				}
		
				
				itemPedidoDAO.eliminar(itemPedido);
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
