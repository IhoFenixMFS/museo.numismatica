package es.sd.practica1.controllers;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import es.sd.practica1.repositorios.*;
import es.sd.practica1.entidades.*;

@Controller
public class EjemplaresController {

	@Autowired
	public RepositorioEjemplares repEjemplares;
	@Autowired
	public RepositorioModelos repModelos;
	@Autowired 
	public RepositorioProveedor repProveedor;
	
	//Operación de Consulta de Ejemplares
	@RequestMapping("/consultarEjemplar")
	public String consult_ejemplar(@RequestParam(value="ejemplaresDisponiblesE", required=false, defaultValue = "0") Integer ejemplaresDisponiblesE,
			@RequestParam(value="anoAcunacionE", required=false, defaultValue = "0") Integer anoAcunacionE,
			@RequestParam(value="ciudadAcunacionE", required=false) String ciudadAcunacionE,
			@RequestParam(value="fechaAdquisicionE", required=false) Date fechaAdquisicionE,
			@RequestParam(value="estadoConservacionE", required=false) String estadoConservacionE,
			@RequestParam(value="modeloE", required=false) String modeloE,
			@RequestParam(value="proveedorE", required=false) String proveedorE,
			@RequestParam(value="ordenarE", required=false) String ordenarE,
			Model modelCE) {
				
		if ( (ejemplaresDisponiblesE==null || ejemplaresDisponiblesE==0) && (anoAcunacionE==null || anoAcunacionE==0) && (ciudadAcunacionE==null || ciudadAcunacionE=="") && (fechaAdquisicionE==null) && (estadoConservacionE==null || estadoConservacionE=="") && (modeloE==null || modeloE=="") && (proveedorE==null || proveedorE=="") ) {
			modelCE.addAttribute("ejemplares", repEjemplares.findAll());		
			
			if ("OrdenarCiudadAcunacionAsc".equals(ordenarE)) {
				modelCE.addAttribute("ejemplares", repEjemplares.findAllByOrderByCiudadAcunacionAsc());
			}
			else if ("OrdenarProveedorAsc".equals(ordenarE)) {
				modelCE.addAttribute("ejemplares", repEjemplares.findAllByOrderByProveedorAsc());
			}
			else if ("OrdenarModeloDesc".equals(ordenarE)) {
				modelCE.addAttribute("ejemplares", repEjemplares.findAllByOrderByModeloDesc());
			}
			else if ("OrdenarAnoAcunacionAsc".equals(ordenarE)) { 
				modelCE.addAttribute("ejemplares", repEjemplares.findAllByOrderByAnoAcunacionAsc());
			}
			else if ("OrdenarFechaAdquisicionAsc".equals(ordenarE)) {
				modelCE.addAttribute("ejemplares", repEjemplares.findAllByOrderByFechaAdquisicionAsc());
			}
			else if ("OrdenarEstadoConservacionDesc".equals(ordenarE)) {
				modelCE.addAttribute("ejemplares", repEjemplares.findAllByOrderByEstadoConservacionDesc());
			}
			else if ("OrdenarEjemplaresDisponiblesDesc".equals(ordenarE)) {
				modelCE.addAttribute("ejemplares", repEjemplares.findAllByOrderByEjemplaresDisponiblesDesc());
			}
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
	
	//Operación de Inserción de Ejemplares
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
	
	//Operación de Modificación de Ejemplares
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
