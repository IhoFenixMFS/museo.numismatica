package es.sd.practica1;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TablonController {

	@Autowired
	private RepositorioProveedor repProveedor;
	@Autowired
	private RepositorioModelos repModelos;
	@Autowired
	private RepositorioEjemplares repEjemplares;

	@PostConstruct
	private void initProveedor() {
		//Datos para la tabla PROVEEDOR
		repProveedor.save(new Proveedor("B0000000A", "Calderilla"));
		repProveedor.save(new Proveedor("B0000123A", "Aurelio", 27456, "au.numismatica@numismatica.com", 695461371));
		repProveedor.save(new Proveedor("B0000321A", "Sancho", 22819, "sanchomuseo@live.com", 785412565));
		repProveedor.save(new Proveedor("B0000122A", "Cecilia", 28900, 632147895));
		repProveedor.save(new Proveedor("B0000312A", "Amelio", 20145, 668794532));
	}
	
	@PostConstruct
	private void initModelos() {
		//Datos para la tabla MODELOS
		repModelos.save(new Modelos("Doblón español", "doblón", 6.77, "oro"));
		repModelos.save(new Modelos("Patagón de brabante", "patagón", 40, 8.9, "plata"));
		repModelos.save(new Modelos("Maravedí español", "maravedí", 35, 4.8, "cobre"));
		repModelos.save(new Modelos("Tetradracma ateniense", "tetradracma", 527, 327.22, "bronce"));
		repModelos.save(new Modelos("Real español", "real", 3.35, "plata"));
	}
	
	@PostConstruct
	private void initEjemplares() {
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

		return "Formulario";
	}

	@RequestMapping("/home")
	public String home(Model modelH) {
		
		return "Home";
	}
	
	
	//CONSULTAS
	@RequestMapping("/consultar")
	public String consult(Model modelC) {

		return "Consultar";
	}
	
	//Operaciones de Consultar	
	@RequestMapping("/consultarProveedor")
	public String consult_proveedor(@RequestParam(value="nombreP", required=false) String nombreP, Model modelCP) {
	
		if (nombreP==null || nombreP=="") {
			modelCP.addAttribute("proveedor", repProveedor.findAll());
		}
		else {
			modelCP.addAttribute("proveedor", repProveedor.findByNombre(nombreP));
		}
		
		return "ConsultarProveedor";
	}	
	
	@RequestMapping("/consultarModelo")
	public String consult_modelo(@RequestParam(value="nombreM", required=false) String nombreM, Model modelCM) {
		
		if (nombreM==null || nombreM=="") {
			modelCM.addAttribute("modelos", repModelos.findAll());
		}		
		else {
			modelCM.addAttribute("modelos", repModelos.findByNombre(nombreM));
		}

		return "ConsultarModelo";
	}		
	
	@RequestMapping("/consultarEjemplar")
	public String consult_ejemplar(@RequestParam(value="numEjemplares", required=false, defaultValue = "0") Integer numEjemplares, Model modelCE) {
				
		if (numEjemplares==null || numEjemplares==0) {
			modelCE.addAttribute("ejemplares", repEjemplares.findAll());
		}
		else {
			modelCE.addAttribute("ejemplares", repEjemplares.findByEjemplaresDisponibles(numEjemplares));
		}
		
		return "ConsultarEjemplar";
	}	
	
	
	//INSERCIONES
	@RequestMapping("/insertar")
	public String insert(Model modelI) {

		return "Insertar";
	}
	
	//Operaciones de Consultar
	@RequestMapping("/insertarEjemplar")
	public String insert_ejemplar(Model modelIE) {
		
		
		return "InsertarEjemplar";
	}
	
	@RequestMapping("/insertarModelo")
	public String insert_modelo(Model modelIM) {

		return "InsertarModelo";
	}
	
	@RequestMapping("/insertarProveedor")
	public String insert_proveedor(Model modelIP) {

		return "InsertarProveedor";
	}
	
	
	//MODIFICACIONES
	@RequestMapping("/modificar")
	public String mod(Model modelM) {

		return "Modificar";
	}
	
	//Operaciones de Modificar
	@RequestMapping("/modificarEjemplar")
	public String mod_ejemplar(Model modelME) {

		return "ModificarEjemplar";
	}
	
	@RequestMapping("/modificarModelo")
	public String mod_modelo(Model modelMM) {

		return "ModificarModelo";
	}
	
	@RequestMapping("/modificarProveedor")
	public String mod_proveedor(Model modelMP) {

		return "ModificarProveedor";
	}	
	
	
}




