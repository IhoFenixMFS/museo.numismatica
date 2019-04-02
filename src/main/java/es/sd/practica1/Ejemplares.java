package es.sd.practica1;

import java.sql.Date;
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
	private java.sql.Date fechaAdquisicion=fechaAct();
	private String estadoConservacion="Normal";
	private String modelo;
	private String proveedor;

	
	public Ejemplares(int ejemplaresDisponibles, String modelo, int anoAcunacion, String ciudadAcunacion,
			Date fecha, String estadoConservacion, String proveedor) {

		this.ejemplaresDisponibles = ejemplaresDisponibles;
		this.modelo = modelo;
		this.anoAcunacion = anoAcunacion;
		this.ciudadAcunacion = ciudadAcunacion;
		this.fechaAdquisicion = fechaPasada(fecha);
		this.estadoConservacion = estadoConservacion;
		this.proveedor = proveedor;
	}
	
	public Ejemplares(int ejemplaresDisponibles, String modelo, int anoAcunacion, String ciudadAcunacion,
			 String estadoConservacion, String proveedor) {
		
		this.ejemplaresDisponibles = ejemplaresDisponibles;
		this.modelo = modelo;
		this.anoAcunacion = anoAcunacion;
		this.ciudadAcunacion = ciudadAcunacion;
		this.fechaAdquisicion = fechaAct();
		this.estadoConservacion = estadoConservacion;
		this.proveedor = proveedor;
	}

	public Ejemplares(int ejemplaresDisponibles, String modelo, int anoAcunacion, String ciudadAcunacion,
			Date fechaAdquisicion, String proveedor)  {	
		
		this.ejemplaresDisponibles = ejemplaresDisponibles;
		this.modelo = modelo;
		this.anoAcunacion = anoAcunacion;
		this.ciudadAcunacion = ciudadAcunacion;
		this.fechaAdquisicion = fechaPasada(fechaAdquisicion);
		this.proveedor = proveedor;
	}

	public Ejemplares(int ejemplaresDisponibles, String modelo, int anoAcunacion, String ciudadAcunacion,
			 String proveedor) {

		this.ejemplaresDisponibles = ejemplaresDisponibles;
		this.modelo = modelo;
		this.anoAcunacion = anoAcunacion;
		this.ciudadAcunacion = ciudadAcunacion;
		this.fechaAdquisicion = fechaAct();
		this.proveedor = proveedor;
	}

	public Ejemplares() {
		
	}

	private java.sql.Date fechaAct() {		
		java.util.Date d = new java.util.Date();  
		java.sql.Date sqldate = new java.sql.Date(d.getTime());
		return sqldate;
	}
	
	private java.sql.Date fechaPasada(Date d) {		
		java.sql.Date sqldate = new java.sql.Date(d.getTime());
		return sqldate;
	}
	
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
