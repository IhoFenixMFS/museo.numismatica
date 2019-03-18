package es.sd.practica1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_proveedor;
	
	private int codigo_fiscal;
	private String nombre;
	private long direccion_postal;
	private String email;
	private long telefono;
	
	public int getCodigo_fiscal() {
		return codigo_fiscal;
	}
	
	public void setCodigo_fiscal(int codigo_fiscal) {
		this.codigo_fiscal = codigo_fiscal;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getDireccion_postal() {
		return direccion_postal;
	}
	
	public void setDireccion_postal(long direccion_postal) {
		this.direccion_postal = direccion_postal;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getTelefono() {
		return telefono;
	}
	
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
	
}
