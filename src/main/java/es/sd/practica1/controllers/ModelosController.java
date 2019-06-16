package es.sd.practica1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import es.sd.practica1.entidades.*;
import es.sd.practica1.repositorios.*;

@Controller
public class ModelosController {

	@Autowired
	public RepositorioModelos repModelos;
	
	//Operación de Consulta de Modelos
	@RequestMapping("/consultarModelo")
	public String consult_modelo(@RequestParam(value="nombreM", required=false) String nombreM, 
			@RequestParam(value="valorFacialM", required=false, defaultValue="0") Double valorFacialM,
			@RequestParam(value="unidadM", required=false) String unidadM,
			@RequestParam(value="diametroM", required=false, defaultValue="0") Double diametroM,
			@RequestParam(value="pesoM", required=false, defaultValue="0") Double pesoM,
			@RequestParam(value="metalM", required=false) String metalM,
			@RequestParam(value="descripcionM", required=false) String descripcionM,
			@RequestParam(value="ordenarM", required=false) String ordenarM,
			Model modelCM) {
		
		if ( (nombreM==null || nombreM=="") && (valorFacialM==null || valorFacialM==0) && (unidadM==null || unidadM=="") && (diametroM==null || diametroM==0) && (pesoM==null || pesoM==0) && (metalM==null || metalM=="") && (descripcionM==null || descripcionM=="") ) {
			modelCM.addAttribute("modelos", repModelos.findAll());
			
			if ("OrdenarNombresAsc".equals(ordenarM)) {
				modelCM.addAttribute("modelos", repModelos.findAllByOrderByNombreAsc());
			}
			else if ("OrdenarValorFacialAsc".equals(ordenarM)) {
				modelCM.addAttribute("modelos", repModelos.findAllByOrderByValorFacialAsc());
			}
			else if ("OrdenarUnidadAsc".equals(ordenarM)) {
				modelCM.addAttribute("modelos", repModelos.findAllByOrderByUnidadAsc());
			}
			else if ("OrdenarDiametroAsc".equals(ordenarM)) { 
				modelCM.addAttribute("modelos", repModelos.findAllByOrderByDiametroAsc());
			}
			else if ("OrdenarPesoDesc".equals(ordenarM)) {
				modelCM.addAttribute("modelos", repModelos.findAllByOrderByPesoDesc());
			}
			else if ("OrdenarMetalDesc".equals(ordenarM)) {
				modelCM.addAttribute("modelos", repModelos.findAllByOrderByMetalDesc());
			}
			else if ("OrdenarDescripcionDesc".equals(ordenarM)) {
				modelCM.addAttribute("modelos", repModelos.findAllByOrderByDescripcionDesc());
			}
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
		else if  ( (nombreM==null || nombreM=="") && (valorFacialM!=null && valorFacialM!=0) && (unidadM!=null || unidadM!="") && (diametroM==null || diametroM==0) && (pesoM==null || pesoM==0) && (metalM==null || metalM=="") && (descripcionM==null || descripcionM=="") ) {
			modelCM.addAttribute("modelos", repModelos.findByValorFacialAndUnidad(valorFacialM,unidadM));
		}
		else if  ( (nombreM==null || nombreM=="") && (valorFacialM==null || valorFacialM==0) && (unidadM==null || unidadM=="") && (diametroM==null || diametroM==0) && (pesoM!=null && pesoM!=0) && (metalM!=null || metalM!="") && (descripcionM==null || descripcionM=="") ) {
			modelCM.addAttribute("modelos", repModelos.findByPesoAndMetal(pesoM,metalM));
		}
		else if  ( (nombreM==null || nombreM=="") && (valorFacialM!=null && valorFacialM!=0) && (unidadM==null || unidadM=="") && (diametroM==null || diametroM==0) && (pesoM!=null && pesoM!=0) && (metalM!=null || metalM!="") && (descripcionM==null || descripcionM=="") ) {
			modelCM.addAttribute("modelos", repModelos.findByValorFacialAndPesoAndMetal(valorFacialM,pesoM,metalM));
		}

		return "ConsultarModelo";
	}		

	//Operación de Inserción de Modelos
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
	
	//Operación de Modificación de Modelos
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
}
