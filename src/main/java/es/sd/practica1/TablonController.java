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
	private RepositorioModelos repModelos;
	private RepositorioEjemplares repEjemplares;

	@PostConstruct
	private void init() {
		repProveedor.save(new Proveedor("B0000000A", "Calderilla"));
		repModelos.save(new Modelos(1, "Doblón español", "doblón", 6.77, "oro"));
		repEjemplares.save(new Ejemplares(1, 1, "Doblón español", 1634, "Valladolid", "01/01/2000", "Calderilla"));
	}

	// Ejemplo Utilizacion de los metodos del repositorio
	@RequestMapping("/")
	public String base(Model model) {
		// model.addAttribute("hola", repProveedor.findByTlf(654234312));
		return "Formulario.html";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		return base(model);
	}

	/*
	 * Con esto definimos en lugar de "/*" la ruta relativa que queremos definir y
	 * en return "/" ponemos return "<nombre del fichero que queremos usar>" para
	 * definir una nueva ruta
	 */
	// IMPORTANTE ---->>>> Poner diferentes nombres a las funcionesS
	@RequestMapping("/*")
	public String pruebas(Model model) {

		return base(model);
	}

}
