package es.sd.practica1.controllers;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import es.sd.practica1.entidades.Ejemplares;
import es.sd.practica1.entidades.Modelos;
import es.sd.practica1.entidades.Proveedor;
import es.sd.practica1.repositorios.*;

@Controller
public class TablonController {

	@Autowired
	public RepositorioEjemplares repEjemplares;
	@Autowired
	public RepositorioModelos repModelos;
	@Autowired 
	public RepositorioProveedor repProveedor;
	
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
		repModelos.save(new Modelos("Doblón español", 1, "doblón", 6.77, "oro"));
		repModelos.save(new Modelos("Patagón de brabante", 1, "patagón", 40, 8.9, "plata"));
		repModelos.save(new Modelos("Maravedí español", 1, "maravedí", 35, 4.8, "cobre"));
		repModelos.save(new Modelos("Tetradracma ateniense", 2, "tetradracma", 527, 327.22, "bronce"));
		repModelos.save(new Modelos("Real español", 5, "real", 3.35, "plata"));
	}
	
	@PostConstruct
	private void initEjemplares() {
		//Datos para la tabla EJEMPLARES		
		repEjemplares.save(new Ejemplares(16, "Doblón español", 1634, "Valladolid", "Malo", "Calderilla"));
		repEjemplares.save(new Ejemplares(3, "Patagón de brabante", 1622, "Segovia", "Normal", "Aurelio"));
		repEjemplares.save(new Ejemplares(3, "Maravedí español", 1685, "Pontevedra", "Bueno", "Sancho"));
		repEjemplares.save(new Ejemplares(3, "Tetradracma ateniense", -562, "Atenas", "Cecilia"));
		repEjemplares.save(new Ejemplares(8, "Real español", 1767, "Madrid", "Malo", "Amelio"));
	}	
	
	//Páginas de inicio
	@RequestMapping("/")
	public String base(Model model) {

		return "Home";
	}

	@RequestMapping("/home")
	public String home(Model model) {
		
		return base(model);
	}
	
	//CONSULTAS
	@RequestMapping("/consultar")
	public String consult(Model modelC) {

		return "Consultar";
	}
	
	//INSERCIONES
	@RequestMapping("/insertar")
	public String insert(Model modelI) {

		return "Insertar";
	}
	
	//MODIFICACIONES
	@RequestMapping("/modificar")
	public String mod(Model modelM) {

		return "Modificar";
	}	
}
