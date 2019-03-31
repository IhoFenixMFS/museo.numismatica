package es.sd.practica1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Modelos {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_modelos;		
	
	private String nombre;	
	private double valorFacial;
	private String unidad;
	private int diametro;
	private double peso;
	private String metal;
	private String descripcion;
	
	//FK de los modelos sobre la tabla ejemplares
	@OneToMany(cascade=CascadeType.ALL) //Unidireccional
	@JoinTable(name = "MOD_EJEM", 
	joinColumns=@JoinColumn(name="ID_ME"))
	private Collection<Ejemplares> ejemplares;	

	//Constructor generado con todos los campos de Ejemplares		
	public Modelos(String nombre, double valorFacial, String unidad, int diametro, double peso, String metal,
			String descripcion) {
		this.nombre = nombre;
		this.valorFacial = valorFacial;
		this.unidad = unidad;
		this.diametro = diametro;
		this.peso = peso;
		this.metal = metal;
		this.descripcion = descripcion;
	}
	
	public Modelos(String nombre, String unidad,int diametro, double peso, String metal) {
		this.nombre = nombre;
		this.unidad = unidad;
		this.diametro = diametro;
		this.peso = peso;
		this.metal = metal;
	}
	
	public Modelos(String nombre, String unidad,double peso, String metal) {
		this.nombre = nombre;
		this.unidad = unidad;
		this.peso = peso;
		this.metal = metal;
	}
	
	public Modelos() {
		
	}
	
	//Getters y Setters automaticos de todos los atributos de la entidad		
	public int getId_modelos() {
		return id_modelos;
	}
	public void setId_modelos(int id) {
		this.id_modelos = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getValorFacial() {
		return valorFacial;
	}
	public void setValorFacial(double valorFacial) {
		this.valorFacial = valorFacial;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public int getDiametro() {
		return diametro;
	}
	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getMetal() {
		return metal;
	}
	public void setMetal(String metal) {
		this.metal = metal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
	