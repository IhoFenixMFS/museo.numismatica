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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;		
	private String nombre;	
	private float valorFacial;
	private String unidad;
	private int diametro;
	private float peso;
	private String metal;
	private String descripcion;
	
	//FK de los modelos sobre la tabla ejemplares
	@OneToMany(cascade=CascadeType.ALL) //Unidireccional
	@JoinTable(name = "MOD_EJEM", 
	joinColumns=@JoinColumn(name="ID_ME"))
	private Collection<Ejemplares> ejemplares;	

	//Constructor generado con todos los campos de Ejemplares		
	public Modelos(int id, String nombre, float valorFacial, String unidad, int diametro, float peso, String metal,
			String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.valorFacial = valorFacial;
		this.unidad = unidad;
		this.diametro = diametro;
		this.peso = peso;
		this.metal = metal;
		this.descripcion = descripcion;
	}
	
	//Getters y Setters automaticos de todos los atributos de la entidad		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getValorFacial() {
		return valorFacial;
	}
	public void setValorFacial(float valorFacial) {
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
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
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
	