package es.sd.practica1;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ModificacionesController{
	

	@Autowired 
	public RepositorioProveedor repProveedor;
	@Autowired
	public RepositorioModelos repModelos;
	@Autowired
	public RepositorioEjemplares repEjemplares;
	
	//MODIFICACIONES
	@RequestMapping("/modificar")
	public String mod(Model modelM) {

		return "Modificar";
	}
	
	//Operaciones de Modificar

	//Proveedor
	@RequestMapping(value="/modificarProveedor/{cif}", method=RequestMethod.GET)
	public String mod_proveedor(@PathVariable("cif") String cifP, Model modelMP) {
		modelMP.addAttribute("proveedor", repProveedor.findByCif(cifP).get(0));
		return "ModificarProveedor";
	}

	@RequestMapping(value="/modificarProveedor/{cif}", method=RequestMethod.PUT)
	public String mod_proveedor_put(@PathVariable("cif") String cifP, @RequestParam(value="cif", required=false, defaultValue = "0") String cif,
			@RequestParam(value="nombre", required=false) String nombre, 
			@RequestParam(value="cp", required=false, defaultValue = "0") Integer cp, 
			@RequestParam(value="mail", required=false) String mail, 
			@RequestParam(value="tlf", required=false, defaultValue = "0") Integer tlf,
			Model modelMM)
	{
		Proveedor proveedor = repProveedor.findByCif(cifP).get(0);


		if (nombre != null) {
			repProveedor.save(new Proveedor(proveedor.getCif(),nombre,cp,mail,tlf));
		}

		return "Consultar";
	}

	//Modelo
	@RequestMapping(value="/modificarModelo/{id}", method=RequestMethod.GET)
	public String mod_modelo(@PathVariable("id") int id, Model modelMP) {
		Modelos modelos = repModelos.findById_modelos(id);
		modelMP.addAttribute("modelo", modelos);
		return "ModificarModelo";
	}

	@RequestMapping(value="/modificarModelo/{id}", method=RequestMethod.PUT)
	public String mod_modelo_put(@PathVariable("id") int id, @RequestParam(value="nombre", required=false) String nombre,
			 @RequestParam(value="valorFacial", required=false, defaultValue = "0") Double valorFacial,
			 @RequestParam(value="unidad", required=false) String unidad,
			 @RequestParam(value="diametro", required=false, defaultValue = "0") Double diametro,
			 @RequestParam(value="peso", required=false, defaultValue = "0") Double peso,
			 @RequestParam(value="metal", required=false) String metal,
			 @RequestParam(value="descripcion", required=false) String descripcion,
			 Model modelMM)
	{
		if (nombre != null) {
			repModelos.save(new Modelos(id, nombre,valorFacial,unidad,diametro,peso,metal,descripcion));
		}

		return "Consultar";
	}


	//Ejemplar
	@RequestMapping(value="/modificarEjemplar/{id}", method=RequestMethod.GET)
	public String mod_ejemplar(@PathVariable("id") int id, Model modelMP) {
		Ejemplares ejemplares = repEjemplares.findById_ejemplares(id);
		List<Modelos> modelos = repModelos.findAll();
		List<Proveedor> proveedores = repProveedor.findAll();

		modelMP.addAttribute("ejemplar", ejemplares);
		modelMP.addAttribute("modelos", modelos);
		modelMP.addAttribute("proveedores", proveedores);
		return "ModificarEjemplar";
	}

	@RequestMapping(value="/modificarEjemplar/{id}", method=RequestMethod.PUT)
	public String mod_ejemplar_put(@PathVariable("id") int id, @RequestParam(value="ejemplaresDisponibles", required=false, defaultValue = "0") Integer ejemplaresDisponibles,
			   @RequestParam(value="anoAcunacion", required=false, defaultValue = "0") Integer anoAcunacion,
			   @RequestParam(value="ciudadAcunacion", required=false) String ciudadAcunacion,
			   @RequestParam(value="fechaAdquisicion", required=false) Date fechaAdquisicion,
			   @RequestParam(value="estadoConservacion", required=false) String estadoConservacion,
			   @RequestParam(value="modelo", required=false) String modelo,
			   @RequestParam(value="proveedor", required=false) String proveedor, Model modelMM) {

		if (ejemplaresDisponibles != 0) {
			repEjemplares.save(new Ejemplares(id, ejemplaresDisponibles,modelo,anoAcunacion,ciudadAcunacion,fechaAdquisicion,estadoConservacion,proveedor));
		}

		return "Consultar";
	}
	
}




