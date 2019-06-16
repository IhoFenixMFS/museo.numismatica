package es.sd.practica1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import es.sd.practica1.entidades.*;
import es.sd.practica1.repositorios.*;

@Controller
public class ProveedorController {

	@Autowired 
	public RepositorioProveedor repProveedor;

	//Operación de Consulta de Proveedores
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
		else if ( (cifP==null || cifP=="") && (nombreP==null || nombreP=="") && (cpP!=null && cpP!=52081) && (mailP==null || mailP=="") && (tlfP!=null && tlfP!=700000000) ) {
			modelCP.addAttribute("proveedor", repProveedor.findByCpAndTlf(cpP,tlfP));
		}
		else if ( (cifP==null || cifP=="") && (nombreP!=null || nombreP!="") && (cpP==null || cpP==52081) && (mailP!=null || mailP!="") && (tlfP==null || tlfP==700000000) ) {
			modelCP.addAttribute("proveedor", repProveedor.findByNombreAndMail(nombreP,mailP));
		}
		
		return "ConsultarProveedor";
	}	
	
	//Operación de Inserción de Proveedores
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
	
	//Operación de Modificación de Proveedores
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
}
