package es.sd.practica1;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioModelos extends JpaRepository<Modelos, Integer> {
	
	public List<Modelos> findByNombre (String nombre);
	public List<Modelos> findByValorFacial (double valorFacial);
	public List<Modelos> findByUnidad (String unidad);
	public List<Modelos> findByDiametro (double diametro);
	public List<Modelos> findByPeso (double peso);
	public List<Modelos> findByMetal (String metal);
	public List<Modelos> findByDescripcion (String descripcion);

	public List<Modelos> findByValorFacialAndUnidad (double valorFacial, String unidad);
	
}
