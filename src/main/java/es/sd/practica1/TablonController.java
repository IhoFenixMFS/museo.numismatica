package es.sd.practica1;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TablonController {
	@Autowired
	private RepositorioProveedor repProveedor;
	
	
	@PostConstruct
	public void init () {
		//repProveedor.save(new Proveedor(1, "Juan", 28942, "ggmalumos@urjc.es", 636234312));
		repProveedor.save(new Proveedor());
	}
	

	
	//Ejemplo Utilizacion de los metodos del repositorio
	@RequestMapping("/")
	public String tablon(Model model) {
  		model.addAttribute("hola", repProveedor.findByTlf(654234312));
  		return "tablon";
  	}
	
}
