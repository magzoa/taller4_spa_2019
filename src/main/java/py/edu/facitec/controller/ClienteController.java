package py.edu.facitec.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import py.edu.facitec.dao.ClienteDAO;
import py.edu.facitec.model.Cliente;

@Controller

@Transactional //Gestiona las operaciones con la bd

public class ClienteController {
	
	
	//Crea un objeto global unico para toda la aplicación
	//Inyección de de dependencia.
	@Autowired
	private ClienteDAO clienteDAO;
	
	
	@RequestMapping("/clientes")
	public String insertar(Cliente cliente){
		
		clienteDAO.guardar(cliente);
		
		System.out.println("Registrado con exito");
		
		return "view/cliente/ok";
	}
	
	
	
	
	

}
