package es.sd.practica1;

import java.sql.Date;

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
		repEjemplares.save(new Ejemplares(16, "Doblón español", 1634, "Valladolid", "Calderilla"));
		repEjemplares.save(new Ejemplares(3, "Patagón de brabante", 1622, "Segovia", "Normal", "Aurelio"));
		repEjemplares.save(new Ejemplares(5, "Maravedí español", 1685, "Pontevedra", "Bueno", "Sancho"));
		repEjemplares.save(new Ejemplares(2, "Tetradracma ateniense", -562, "Atenas", "Cecilia"));
		repEjemplares.save(new Ejemplares(8, "Real español", 1767, "Madrid", "Malo", "Amelio"));
	}
		

	// Ejemplo Utilizacion de los metodos del repositorio
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
	
	//Operaciones de Consultar	
	@RequestMapping("/consultarProveedor")
	public String consult_proveedor(@RequestParam(value="cifP", required=false) String cifP, 
			@RequestParam(value="nombreP", required=false) String nombreP,
			@RequestParam(value="cpP", required=false, defaultValue="52081") Integer cpP,
			@RequestParam(value="mailP", required=false) String mailP,
			@RequestParam(value="tlfP", required=false, defaultValue="700000000") Integer tlfP,
			Model modelCP) {
		
		if ( (cifP==null || cifP=="") && (nombreP==null || nombreP=="") && (cpP==null || cpP==52081) && (mailP==null || mailP=="") && (tlfP==null || tlfP==700000000) ) {
			modelCP.addAttribute("proveedor", repProveedor.findAll());
		}
		else if ( (cifP!=null || cifP!="") && (nombreP==null || nombreP=="") && (cpP==null || cpP==52081) && (mailP==null || mailP=="") && (tlfP==null || tlfP==700000000) ) {
			modelCP.addAttribute("proveedor", repProveedor.findByCif(cifP));
		}
		else if ( (cifP==null || cifP=="") && (nombreP!=null || nombreP!="") && (cpP==null || cpP==52081) && (mailP==null || mailP=="") && (tlfP==null || tlfP==700000000) ) {
			modelCP.addAttribute("proveedor", repProveedor.findByNombre(nombreP));
		}
		else if ( (cifP==null || cifP=="") && (nombreP==null || nombreP=="") && (cpP!=null && cpP!=52081) && (mailP==null || mailP=="") && (tlfP==null || tlfP==700000000) ) {
			modelCP.addAttribute("proveedor", repProveedor.findByCp(cpP));
		}
		else if ( (cifP==null || cifP=="") && (nombreP==null || nombreP=="") && (cpP==null || cpP==52081) && (mailP!=null || mailP!="") && (tlfP==null || tlfP==700000000) ) {
			modelCP.addAttribute("proveedor", repProveedor.findByMail(mailP));
		}
		else if ( (cifP==null || cifP=="") && (nombreP==null || nombreP=="") && (cpP==null || cpP==52081) && (mailP==null || mailP=="") && (tlfP!=null && tlfP!=700000000) ) {
			modelCP.addAttribute("proveedor", repProveedor.findByTlf(tlfP));
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
	@RequestMapping(value = "/insertarProveedor")
	public String insert_proveedor(@RequestParam(value="cif", required=false, defaultValue = "0") String cif, 
			@RequestParam(value="nombre", required=false) String nombre, 
			@RequestParam(value="cp", required=false, defaultValue = "0") Integer cp, 
			@RequestParam(value="mail", required=false) String mail, 
			@RequestParam(value="tlf", required=false, defaultValue = "0") Integer tlf,  
			Model modelIP) {
		
		if (nombre != null) {
			repProveedor.save(new Proveedor(cif,nombre,cp,mail,tlf));
		}
		return "InsertarProveedor";
	}
	
	@RequestMapping("/insertarModelo")
	public String insert_modelo(@RequestParam(value="nombre", required=false) String nombre, 
			@RequestParam(value="valorFacial", required=false, defaultValue = "0") Double valorFacial, 
			@RequestParam(value="unidad", required=false) String unidad, 
			@RequestParam(value="diametro", required=false, defaultValue = "0") Double diametro, 
			@RequestParam(value="peso", required=false, defaultValue = "0") Double peso,
			@RequestParam(value="metal", required=false) String metal, 
			@RequestParam(value="descripcion", required=false) String descripcion, 
			Model modelIM) {

		
		if (nombre != null) {
			repModelos.save(new Modelos(nombre,valorFacial,unidad,diametro,peso,metal,descripcion));
		}	
		return "InsertarModelo";
	}	

	@RequestMapping("/insertarEjemplar")
	public String insert_ejemplar(@RequestParam(value="ejemplaresDisponibles", required=false, defaultValue = "0") Integer ejemplaresDisponibles, 
			@RequestParam(value="anoAcunacion", required=false, defaultValue = "0") Integer anoAcunacion, 
			@RequestParam(value="ciudadAcunacion", required=false) String ciudadAcunacion, 
			@RequestParam(value="fechaAdquisicion", required=false) Date fechaAdquisicion, 
			@RequestParam(value="estadoConservacion", required=false) String estadoConservacion, 
			@RequestParam(value="modelo", required=false) String modelo,
			@RequestParam(value="proveedor", required=false) String proveedor,
			Model modelIE) {

		modelIE.addAttribute("modelos", repModelos.findAll());
		modelIE.addAttribute("proveedores", repProveedor.findAll());
		
		if (ejemplaresDisponibles != 0) {
			repEjemplares.save(new Ejemplares(ejemplaresDisponibles,modelo,anoAcunacion,ciudadAcunacion,fechaAdquisicion,estadoConservacion,proveedor));
		}		
		return "InsertarEjemplar";
	}	
	
	
	//MODIFICACIONES
	@RequestMapping("/modificar")
	public String mod(Model modelM) {

		return "Modificar";
	}
	
	//Operaciones de Modificar
	@RequestMapping("/modificarProveedor")
	public String mod_proveedor(Model modelMP) {

		return "ModificarProveedor";
	}
	
	@RequestMapping("/modificarModelo")
	public String mod_modelo(Model modelMM) {

		return "ModificarModelo";
	}
	
	@RequestMapping("/modificarEjemplar")
	public String mod_ejemplar(Model modelME) {

		return "ModificarEjemplar";
	}
	
}




