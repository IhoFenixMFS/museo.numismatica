package es.sd.practica1;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ejemplares {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int ejemplaresDisponibles;
	private int anoAcunacion;
	private String ciudadAcunacion;
	private java.sql.Date fechaAdquisicion;
	private String estadoConservacion;
	private String modelo;
	private String proveedor;

	// Constructor generado con todos los campos de Ejemplares
	public Ejemplares(int id, int ejemplaresDisponibles, String modelo, int anoAcunacion, String ciudadAcunacion,
			java.sql.Date fechaAdquisicion, String estadoConservacion, String proveedor) {
		this.id = id;
		this.ejemplaresDisponibles = ejemplaresDisponibles;
		this.modelo = modelo;
		this.anoAcunacion = anoAcunacion;
		this.ciudadAcunacion = ciudadAcunacion;
		this.fechaAdquisicion = fechaAdquisicion;
		this.estadoConservacion = estadoConservacion;
		this.proveedor = proveedor;
	}

	public Ejemplares(int id, int ejemplaresDisponibles, String modelo, int anoAcunacion, String ciudadAcunacion,
			String fecha, String proveedor)  {
		Date d=null;
		DateFormat df = DateFormat.getDateInstance();
		try {
			d= (Date) df.parse(fecha);
		} catch (Exception e) {
			
		}
		
		this.id = id;
		this.ejemplaresDisponibles = ejemplaresDisponibles;
		this.modelo = modelo;
		this.anoAcunacion = anoAcunacion;
		this.ciudadAcunacion = ciudadAcunacion;
		this.fechaAdquisicion = d;
		this.proveedor = proveedor;
	}

	public Ejemplares() {
	}

	// Getters y Setters automaticos de todos los atributos de la entidad
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
