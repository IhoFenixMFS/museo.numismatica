package es.sd.practica1;

import java.util.*;
import javax.persistence.*;

@Entity
public class Proveedor {

	@Id
	private String cif;
	private String nombre;
	private int cp;
	private String mail;
	private int tlf;
	
	@ManyToMany(cascade=CascadeType.ALL) 
	@JoinTable(name="PROV_EJEM",
	joinColumns=@JoinColumn(name="ID_PE"))
	private Collection<Ejemplares> ejemplares;
	
	//Constructores
	public Proveedor(String cif, String nombre, int cp, String mail, int tlf) {
		this.cif = cif;
		this.nombre = nombre;
		this.cp = cp;
		this.mail = mail;
		this.tlf = tlf;
	}
	
	public Proveedor(String cif, String nombre) {
		this.cif = cif;
		this.nombre = nombre;
	}
	
	public Proveedor(String cif, String nombre, int cp, int tlf) {
		this.cif = cif;
		this.nombre = nombre;
		this.cp = cp;
		this.tlf = tlf;
	}
	
	public Proveedor() {
	}
	

	//Getters y Setters automaticos de todos los atributos de la entidad	
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
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
