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
	@Autowired
	private RepositorioModelos repModelos;
	@Autowired
	private RepositorioEjemplares repEjemplares;

	@PostConstruct
	private void init() {
		//Datos para la tabla PROVEEDOR
		repProveedor.save(new Proveedor("B0000000A", "Calderilla"));
		repProveedor.save(new Proveedor("B0000123A", "Aurelio", 27456, "au.numismatica@numismatica.com", 695461371));
		repProveedor.save(new Proveedor("B0000321A", "Sancho", 22819, "sanchomuseo@live.com", 785412565));
		repProveedor.save(new Proveedor("B0000122A", "Cecilia", 28900, 632147895));
		repProveedor.save(new Proveedor("B0000312A", "Amelio", 20145, 668794532));
		
		//Datos para la tabla MODELOS
		repModelos.save(new Modelos("Doblón español", "doblón", 6.77, "oro"));
		repModelos.save(new Modelos("Patagón de brabante", "patagón", 40, 8.9, "plata"));
		repModelos.save(new Modelos("Maravedí español", "maravedí", 35, 4.8, "cobre"));
		repModelos.save(new Modelos("Tetradracma ateniense", "tetradracma", 527, 327.22, "bronce"));
		repModelos.save(new Modelos("Real español", "real", 3.35, "plata"));
		
		//Datos para la tabla EJEMPLARES
		repEjemplares.save(new Ejemplares(16, "Doblón español", 1634, "Valladolid", "01/01/2000", "Calderilla"));
		repEjemplares.save(new Ejemplares(3, "Patagón de brabante", 1622, "Segovia", "13/03/2004", "deteriorado", "Aurelio"));
		repEjemplares.save(new Ejemplares(5, "Maravedí español", 1685, "Pontevedra", "05/08/1998", "oxidado", "Sancho"));
		repEjemplares.save(new Ejemplares(2, "Tetradracma ateniense", -562, "Atenas", "14/07/1991", "Cecilia"));
		repEjemplares.save(new Ejemplares(8, "Real español", 1767, "Madrid", "19/05/2008", "desgastado", "Amelio"));
	}

	// Ejemplo Utilizacion de los metodos del repositorio
	@RequestMapping("/")
	public String base(Model model) {
		model.addAttribute("proveedor", repProveedor.findAll());
		model.addAttribute("modelo", new Modelos("Doblón español", "doblón", 6.77, "oro"));
		return "Formulario";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		return base(model);
	}

	@RequestMapping("/*")
	public String pruebas(Model model) {

		return "index";
	}
	
	
	
    //PLANTILLA DEL CONTROLADOR DEL FORMULARIO
	//Hay que configurarlo con nuestro proyecto en base a el siguiente ejemplo controlador
	/*
	@RequestMapping("/form")
    public String showUserForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "userForm";
    }

    @RequestMapping("/create")
    public ModelAndView createUser(@Valid Usuario user, BindingResult result) {
        ModelAndView model = new ModelAndView();
        model.addObject("usuario", user);
        model.setViewName(result.hasErrors() ? "userForm" : "userReady"); 
        return model;
    }
    */
}
