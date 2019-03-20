package es.sd.practica1;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProveedor extends JpaRepository<Proveedor, Integer> {

	Proveedor findByNombre (String nombre);
	Proveedor findByCP (int cp);
	Proveedor findByMail (String mail);
	Proveedor findByTLF (float tlf);
	
	List<Proveedor> findByCPAndTLF (int cp, float tlf); 

}
