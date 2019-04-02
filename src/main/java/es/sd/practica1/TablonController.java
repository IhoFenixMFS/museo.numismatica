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
		repModelos.save(new Modelos("Doblón español", 1.2, "doblón", 6.77, "oro"));
		repModelos.save(new Modelos("Patagón de brabante", 2, "patagón", 40, 8.9, "plata"));
		repModelos.save(new Modelos("Maravedí español", 3, "maravedí", 35, 4.8, "cobre"));
		repModelos.save(new Modelos("Tetradracma ateniense", 5, "tetradracma", 527, 327.22, "bronce"));
		repModelos.save(new Modelos("Real español", 1, "real", 3.35, "plata"));
	}
	
	@PostConstruct
	private void initEjemplares() {
		//Datos para la tabla EJEMPLARES		
		repEjemplares.save(new Ejemplares(16, "Doblón español", 1634, "Valladolid", "Malo", "Calderilla"));
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
	public String consult_modelo(@RequestParam(value="nombreM", required=false) String nombreM, 
			@RequestParam(value="valorFacialM", required=false, defaultValue="0") Double valorFacialM,
			@RequestParam(value="unidadM", required=false) String unidadM,
			@RequestParam(value="diametroM", required=false, defaultValue="0") Double diametroM,
			@RequestParam(value="pesoM", required=false, defaultValue="0") Double pesoM,
			@RequestParam(value="metalM", required=false) String metalM,
			@RequestParam(value="descripcionM", required=false) String descripcionM,
			Model modelCM) {
		
		if ( (nombreM==null || nombreM=="") && (valorFacialM==null || valorFacialM==0) && (unidadM==null || unidadM=="") && (diametroM==null || diametroM==0) && (pesoM==null || pesoM==0) && (metalM==null || metalM=="") && (descripcionM==null || descripcionM=="") ) {
			modelCM.addAttribute("modelos", repModelos.findAll());
		}		
		else if  ( (nombreM!=null || nombreM!="") && (valorFacialM==null || valorFacialM==0) && (unidadM==null || unidadM=="") && (diametroM==null || diametroM==0) && (pesoM==null || pesoM==0) && (metalM==null || metalM=="") && (descripcionM==null || descripcionM=="") ) {
			modelCM.addAttribute("modelos", repModelos.findByNombre(nombreM));
		}
		else if  ( (nombreM==null || nombreM=="") && (valorFacialM!=null && valorFacialM!=0) && (unidadM==null || unidadM=="") && (diametroM==null || diametroM==0) && (pesoM==null || pesoM==0) && (metalM==null || metalM=="") && (descripcionM==null || descripcionM=="") ) {
			modelCM.addAttribute("modelos", repModelos.findByValorFacial(valorFacialM));
		}
		else if  ( (nombreM==null || nombreM=="") && (valorFacialM==null || valorFacialM==0) && (unidadM!=null || unidadM!="") && (diametroM==null || diametroM==0) && (pesoM==null || pesoM==0) && (metalM==null || metalM=="") && (descripcionM==null || descripcionM=="") ) {
			modelCM.addAttribute("modelos", repModelos.findByUnidad(unidadM));
		}
		else if  ( (nombreM==null || nombreM=="") && (valorFacialM==null || valorFacialM==0) && (unidadM==null || unidadM=="") && (diametroM!=null && diametroM!=0) && (pesoM==null || pesoM==0) && (metalM==null || metalM=="") && (descripcionM==null || descripcionM=="") ) {
			modelCM.addAttribute("modelos", repModelos.findByDiametro(diametroM));
		}
		else if  ( (nombreM==null || nombreM=="") && (valorFacialM==null || valorFacialM==0) && (unidadM==null || unidadM=="") && (diametroM==null || diametroM==0) && (pesoM!=null && pesoM!=0) && (metalM==null || metalM=="") && (descripcionM==null || descripcionM=="") ) {
			modelCM.addAttribute("modelos", repModelos.findByPeso(pesoM));
		}
		else if  ( (nombreM==null || nombreM=="") && (valorFacialM==null || valorFacialM==0) && (unidadM==null || unidadM=="") && (diametroM==null || diametroM==0) && (pesoM==null || pesoM==0) && (metalM!=null || metalM!="") && (descripcionM==null || descripcionM=="") ) {
			modelCM.addAttribute("modelos", repModelos.findByMetal(metalM));
		}
		else if  ( (nombreM==null || nombreM=="") && (valorFacialM==null || valorFacialM==0) && (unidadM==null || unidadM=="") && (diametroM==null || diametroM==0) && (pesoM==null || pesoM==0) && (metalM==null || metalM=="") && (descripcionM!=null || descripcionM!="") ) {
			modelCM.addAttribute("modelos", repModelos.findByDescripcion(descripcionM));
		}

		return "ConsultarModelo";
	}		
	
	@RequestMapping("/consultarEjemplar")
	public String consult_ejemplar(@RequestParam(value="ejemplaresDisponiblesE", required=false, defaultValue = "0") Integer ejemplaresDisponiblesE,
			@RequestParam(value="anoAcunacionE", required=false, defaultValue = "0") Integer anoAcunacionE,
			@RequestParam(value="ciudadAcunacionE", required=false) String ciudadAcunacionE,
			@RequestParam(value="fechaAdquisicionE", required=false) Date fechaAdquisicionE,
			@RequestParam(value="estadoConservacionE", required=false) String estadoConservacionE,
			@RequestParam(value="modeloE", required=false) String modeloE,
			@RequestParam(value="proveedorE", required=false) String proveedorE,
			Model modelCE) {
				
		if ( (ejemplaresDisponiblesE==null || ejemplaresDisponiblesE==0) && (anoAcunacionE==null || anoAcunacionE==0) && (ciudadAcunacionE==null || ciudadAcunacionE=="") && (fechaAdquisicionE==null) && (estadoConservacionE==null || estadoConservacionE=="") && (modeloE==null || modeloE=="") && (proveedorE==null || proveedorE=="") ) {
			modelCE.addAttribute("ejemplares", repEjemplares.findAll());
		}		
		else if ( (ejemplaresDisponiblesE!=null && ejemplaresDisponiblesE!=0) && (anoAcunacionE==null || anoAcunacionE==0) && (ciudadAcunacionE==null || ciudadAcunacionE=="") && (fechaAdquisicionE==null) && (estadoConservacionE==null || estadoConservacionE=="") && (modeloE==null || modeloE=="") && (proveedorE==null || proveedorE=="") ) {
			modelCE.addAttribute("ejemplares", repEjemplares.findByEjemplaresDisponibles(ejemplaresDisponiblesE));
		}
		else if ( (ejemplaresDisponiblesE==null || ejemplaresDisponiblesE==0) && (anoAcunacionE!=null && anoAcunacionE!=0) && (ciudadAcunacionE==null || ciudadAcunacionE=="") && (fechaAdquisicionE==null) && (estadoConservacionE==null || estadoConservacionE=="") && (modeloE==null || modeloE=="") && (proveedorE==null || proveedorE=="") ) {
			modelCE.addAttribute("ejemplares", repEjemplares.findByAnoAcunacion(anoAcunacionE));
		}
		else if ( (ejemplaresDisponiblesE==null || ejemplaresDisponiblesE==0) && (anoAcunacionE==null || anoAcunacionE==0) && (ciudadAcunacionE!=null || ciudadAcunacionE!="") && (fechaAdquisicionE==null) && (estadoConservacionE==null || estadoConservacionE=="") && (modeloE==null || modeloE=="") && (proveedorE==null || proveedorE=="") ) {
			modelCE.addAttribute("ejemplares", repEjemplares.findByCiudadAcunacion(ciudadAcunacionE));
		}
		else if ( (ejemplaresDisponiblesE==null || ejemplaresDisponiblesE==0) && (anoAcunacionE==null || anoAcunacionE==0) && (ciudadAcunacionE==null || ciudadAcunacionE=="") && (fechaAdquisicionE!=null) && (estadoConservacionE==null || estadoConservacionE=="") && (modeloE==null || modeloE=="") && (proveedorE==null || proveedorE=="") ) {
			modelCE.addAttribute("ejemplares", repEjemplares.findByFechaAdquisicion(fechaAdquisicionE));
		}
		else if ( (ejemplaresDisponiblesE==null || ejemplaresDisponiblesE==0) && (anoAcunacionE==null || anoAcunacionE==0) && (ciudadAcunacionE==null || ciudadAcunacionE=="") && (fechaAdquisicionE==null) && (estadoConservacionE!=null || estadoConservacionE!="") && (modeloE==null || modeloE=="") && (proveedorE==null || proveedorE=="") ) {
			modelCE.addAttribute("ejemplares", repEjemplares.findByEstadoConservacion(estadoConservacionE));
		}
		else if ( (ejemplaresDisponiblesE==null || ejemplaresDisponiblesE==0) && (anoAcunacionE==null || anoAcunacionE==0) && (ciudadAcunacionE==null || ciudadAcunacionE=="") && (fechaAdquisicionE==null) && (estadoConservacionE==null || estadoConservacionE=="") && (modeloE!=null || modeloE!="") && (proveedorE==null || proveedorE=="") ) {
			modelCE.addAttribute("ejemplares", repEjemplares.findByModelo(modeloE));
		}
		else if ( (ejemplaresDisponiblesE==null || ejemplaresDisponiblesE==0) && (anoAcunacionE==null || anoAcunacionE==0) && (ciudadAcunacionE==null || ciudadAcunacionE=="") && (fechaAdquisicionE==null) && (estadoConservacionE==null || estadoConservacionE=="") && (modeloE==null || modeloE=="") && (proveedorE!=null || proveedorE!="") ) {
			modelCE.addAttribute("ejemplares", repEjemplares.findByProveedor(proveedorE));
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




