package es.sd.practica1;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InsercionesController{

	@Autowired 
	public RepositorioProveedor repProveedor;
	@Autowired
	public RepositorioModelos repModelos;
	@Autowired
	public RepositorioEjemplares repEjemplares;
	
	//INSERCIONES
	@RequestMapping("/insertar")
	public String insert(Model modelI) {

		return "Insertar";
	}
	
	//Operaciones de Insertar	
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
	
}




