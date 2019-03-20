package es.sd.practica1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Ejemplares {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int ejemplaresDisponibles;
	private int anoAcunacion;
	private String ciudadAcunacion;
	private java.sql.Date fechaAdquisicion;
	private String estadoConservacion;	
	private String proveedor;	
	private String modelo;
	
	//Clave Foranea OneToOne bidireccional Ejemplares-Proveedor
	@OneToOne
	private Proveedor fk_proveedor;
	
	
	//Constructor generado con todos los campos de Ejemplares
	public Ejemplares(int id, int ejemplaresDisponibles, String modelo, int anoAcunacion, String ciudadAcunacion,
			java.sql.Date fechaAdquisicion, String estadoConservacion, String proveedor) {
		super();
		this.id = id;
		this.ejemplaresDisponibles = ejemplaresDisponibles;
		this.modelo = modelo;
		this.anoAcunacion = anoAcunacion;
		this.ciudadAcunacion = ciudadAcunacion;
		this.fechaAdquisicion = fechaAdquisicion;
		this.estadoConservacion = estadoConservacion;
		this.proveedor = proveedor;
	}
	
	//Getters y Setters automaticos de todos los atributos de la entidad
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
