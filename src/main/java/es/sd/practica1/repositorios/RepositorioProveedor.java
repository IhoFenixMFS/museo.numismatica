package es.sd.practica1.repositorios;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import es.sd.practica1.entidades.*;

public interface RepositorioProveedor extends JpaRepository<Proveedor, String> {

	public List<Proveedor> findByCif (String cif);
	public List<Proveedor> findByNombre (String nombre);
	public List<Proveedor> findByCp (int cp);
	public List<Proveedor> findByMail (String mail);
	public List<Proveedor> findByTlf (int tlf);	
	public List<Proveedor> findByCpAndTlf (int cp, int tlf); 
	public List<Proveedor> findByNombreAndMail (String nombre, String mail);  
	public List<Proveedor> findByNombreAndMailAndTlf (String nombre, String mail, int tlf);  
	
	public List<Proveedor> findAllByOrderByNombreAsc();
	public List<Proveedor> findAllByOrderByNombreDesc();
	public List<Proveedor> findAllByOrderByCifAsc();
	public List<Proveedor> findAllByOrderByCpDesc();
	public List<Proveedor> findAllByOrderByTlfAsc();

}
