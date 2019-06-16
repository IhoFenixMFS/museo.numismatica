package es.sd.practica1.repositorios;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import es.sd.practica1.entidades.*;

public interface RepositorioModelos extends JpaRepository<Modelos, Integer> {

	@Query("SELECT m FROM Modelos m WHERE m.id_modelos=?1")
	public Modelos findById_modelos(Integer id_modelos);

	public List<Modelos> findByNombre (String nombre);
	public List<Modelos> findByValorFacial (double valorFacial);
	public List<Modelos> findByUnidad (String unidad);
	public List<Modelos> findByDiametro (double diametro);
	public List<Modelos> findByPeso (double peso);
	public List<Modelos> findByMetal (String metal);
	public List<Modelos> findByDescripcion (String descripcion);
	public List<Modelos> findByValorFacialAndUnidad (double valorFacial, String unidad);
	public List<Modelos> findByPesoAndMetal (double peso, String metal);
	public List<Modelos> findByValorFacialAndPesoAndMetal (double valorFacial, double peso, String metal);
	
	public List<Modelos> findAllByOrderByNombreAsc();
	public List<Modelos> findAllByOrderByValorFacialAsc();
	public List<Modelos> findAllByOrderByUnidadAsc();
	public List<Modelos> findAllByOrderByDiametroAsc();
	public List<Modelos> findAllByOrderByPesoDesc();
	public List<Modelos> findAllByOrderByMetalDesc();
	public List<Modelos> findAllByOrderByDescripcionDesc();
	
}
