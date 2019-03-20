package es.sd.practica1;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositorioEjemplares extends JpaRepository<Ejemplares, Integer> {
	
	Ejemplares findByEjemplaresDisponibles (int ejemplaresDisponibles);
	Ejemplares findByAnoAcunacion (int anoAcunacion);
	Ejemplares findByCiudadAcunacion (String ciudadAcunacion);
	Ejemplares findByFechaAdquisicion (java.sql.Date fechaAdquisicion);
	Ejemplares findByEstadoConservacion (String estadoConservacion);
	
	//No sabemos si poner estas 2 como claves foraneas
	Ejemplares findByProveedor (String proveedor);
	Ejemplares findByModelo (String Modelo);

	List<Ejemplares> findByAnoAcunacionAndCiudadAcunacion (int anoAcunacion, String ciudadAcunacion); 

}
