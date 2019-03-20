package es.sd.practica1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Proveedor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cif;
	
	private String nombre;
	private int cp;
	private String mail;
	private int tlf;
	
	//Clave Foranea bidireccional Proveedor-Ejemplares
	@OneToOne (mappedBy = "fk_proveedor")
	private Ejemplares fk_ejemplar;
	
	//Constructor generado con todos los campos de Ejemplares	
	public Proveedor(int cif, String nombre, int cp, String mail, int tlf) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.cp = cp;
		this.mail = mail;
		this.tlf = tlf;
	}
	
	public Proveedor() {
		super();
		this.cif = 1;
		this.nombre = "Lucas";
		this.cp = 28942;
		this.mail = "ggmalumno@urjc.es";
		this.tlf = 654234312;
	}

	//Getters y Setters automaticos de todos los atributos de la entidad	
	public int getCif() {
		return cif;
	}
	public void setCif(int cif) {
		this.cif = cif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	
	
}
