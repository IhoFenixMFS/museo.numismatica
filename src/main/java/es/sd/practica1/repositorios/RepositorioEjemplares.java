package es.sd.practica1.repositorios;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import es.sd.practica1.entidades.*;


public interface RepositorioEjemplares extends JpaRepository<Ejemplares, Integer> {

	@Query("SELECT e FROM Ejemplares e WHERE e.id_ejemplares=?1")
	public Ejemplares findById_ejemplares(Integer id_ejemplar);

	public List<Ejemplares> findByEjemplaresDisponibles (int ejemplaresDisponibles);
	public List<Ejemplares> findByAnoAcunacion (int anoAcunacion);
	public List<Ejemplares> findByCiudadAcunacion (String ciudadAcunacion);
	public List<Ejemplares> findByFechaAdquisicion (java.sql.Date fechaAdquisicion);
	public List<Ejemplares> findByEstadoConservacion (String estadoConservacion);	
	public List<Ejemplares> findByProveedor (String proveedor);
	public List<Ejemplares> findByModelo (String Modelo);
	public List<Ejemplares> findByAnoAcunacionAndCiudadAcunacion (int anoAcunacion, String ciudadAcunacion); 
	
	public List<Ejemplares> findAllByOrderByCiudadAcunacionAsc();
	public List<Ejemplares> findAllByOrderByProveedorAsc();
	public List<Ejemplares> findAllByOrderByModeloDesc();
	public List<Ejemplares> findAllByOrderByAnoAcunacionAsc();
	public List<Ejemplares> findAllByOrderByFechaAdquisicionAsc();
	public List<Ejemplares> findAllByOrderByEstadoConservacionDesc();
	public List<Ejemplares> findAllByOrderByEjemplaresDisponiblesDesc();

}
