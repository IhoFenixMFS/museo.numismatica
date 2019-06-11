package es.sd.practica1;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ConsultasController{


	@Autowired 
	public RepositorioProveedor repProveedor;
	@Autowired
	public RepositorioModelos repModelos;
	@Autowired
	public RepositorioEjemplares repEjemplares;
	
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
			@RequestParam(value="ordenarP", required=false) String ordenarP,
			Model modelCP) {
			
		if ( (cifP==null || cifP=="") && (nombreP==null || nombreP=="") && (cpP==null || cpP==52081) && (mailP==null || mailP=="") && (tlfP==null || tlfP==700000000)) {
			modelCP.addAttribute("proveedor", repProveedor.findAll());		
			
			if ("OrdenarNombresAsc".equals(ordenarP)) {
				modelCP.addAttribute("proveedor", repProveedor.findAllByOrderByNombreAsc());
			}
			else if ("OrdenarNombresDesc".equals(ordenarP)) {
				modelCP.addAttribute("proveedor", repProveedor.findAllByOrderByNombreDesc());
			}
			else if ("OrdenarCifAsc".equals(ordenarP)) {
				modelCP.addAttribute("proveedor", repProveedor.findAllByOrderByCifAsc());
			}
			else if ("OrdenarCpDesc".equals(ordenarP)) { 
				modelCP.addAttribute("proveedor", repProveedor.findAllByOrderByCpDesc());
			}
			else if ("OrdenarTlfAsc".equals(ordenarP)) {
				modelCP.addAttribute("proveedor", repProveedor.findAllByOrderByTlfAsc());
			}
			
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
	
}




