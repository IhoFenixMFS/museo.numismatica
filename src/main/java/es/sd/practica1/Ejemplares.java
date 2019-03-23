package es.sd.practica1;

import java.sql.Date;
import java.text.DateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ejemplares {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ejemplares;
	
	private int ejemplaresDisponibles;
	private int anoAcunacion;
	private String ciudadAcunacion;
	private java.sql.Date fechaAdquisicion;
	private String estadoConservacion;
	private String modelo;
	private String proveedor;

	// Constructor generado con todos los campos de Ejemplares
	public Ejemplares(int ejemplaresDisponibles, String modelo, int anoAcunacion, String ciudadAcunacion,
			String fechaAdquisicion, String estadoConservacion, String proveedor) {
		
		Date fechasql = null;
		DateFormat df = DateFormat.getDateInstance();
		try {
			fechasql = (Date) df.parse(fechaAdquisicion);
		} catch (Exception e) {
			
		}
		
		this.ejemplaresDisponibles = ejemplaresDisponibles;
		this.modelo = modelo;
		this.anoAcunacion = anoAcunacion;
		this.ciudadAcunacion = ciudadAcunacion;
		this.fechaAdquisicion = fechasql;
		this.estadoConservacion = estadoConservacion;
		this.proveedor = proveedor;
	}

	public Ejemplares(int ejemplaresDisponibles, String modelo, int anoAcunacion, String ciudadAcunacion,
			String fechaAdquisicion, String proveedor)  {
		
		Date fechasql = null;
		DateFormat df = DateFormat.getDateInstance();
		try {
			fechasql = (Date) df.parse(fechaAdquisicion);
		} catch (Exception e) {
			
		}
		
		this.ejemplaresDisponibles = ejemplaresDisponibles;
		this.modelo = modelo;
		this.anoAcunacion = anoAcunacion;
		this.ciudadAcunacion = ciudadAcunacion;
		this.fechaAdquisicion = fechasql;
		this.proveedor = proveedor;
	}

	public Ejemplares() {
	}

	// Getters y Setters automaticos de todos los atributos de la entidad
	public int getId_ejemplares() {
		return id_ejemplares;
	}

	public void setId_ejemplares(int id) {
		this.id_ejemplares = id;
	}

	public int getEjemplaresDisponibles() {
		return ejemplaresDisponibles;
	}

	public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
		this.ejemplaresDisponibles = ejemplaresDisponibles;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoAcunacion() {
		return anoAcunacion;
	}

	public void setAnoAcunacion(int anoAcunacion) {
		this.anoAcunacion = anoAcunacion;
	}

	public String getCiudadAcunacion() {
		return ciudadAcunacion;
	}

	public void setCiudadAcunacion(String ciudadAcunacion) {
		this.ciudadAcunacion = ciudadAcunacion;
	}

	public java.sql.Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(java.sql.Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public String getEstadoConservacion() {
		return estadoConservacion;
	}

	public void setEstadoConservacion(String estadoConservacion) {
		this.estadoConservacion = estadoConservacion;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

}
