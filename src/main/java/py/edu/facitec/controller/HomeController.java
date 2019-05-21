package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
		//La URL a responder
	@RequestMapping("/")
	public String index(){
		
		System.out.println("Hola Mundo Spring MVC");
		
		
			//Página a responder
		return "view/templates/index";
	}
	
	
	

}
