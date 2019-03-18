package es.sd.practica1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Moneda {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_moneda;
	
	private float valor;
	private String unidad_monetaria;
	private float diametro;
	private float peso;
	private String composicion;
	private String descripcion;
	private int num_ejemplares;
	private String modelo;
	private java.sql.Date fecha_creacion;
	private String ciudad;
	private java.sql.Date fecha_adquisicion;
	private String estado_conservacion;
	private Proveedor proveedor;
	
	
}
