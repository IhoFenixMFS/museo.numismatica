package es.sd.practica1;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProveedor extends JpaRepository<Proveedor, Integer> {

	Proveedor findByNombre (String nombre);
	Proveedor findByCp (int cp);
	Proveedor findByMail (String mail);
	Proveedor findByTlf (int tlf);
	
	List<Proveedor> findByCpAndTlf (int cp, int tlf); 

}
