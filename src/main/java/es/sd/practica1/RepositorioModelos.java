package es.sd.practica1;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioModelos extends JpaRepository<Modelos, Integer> {
	
	Modelos findByNombre (String nombre);
	Modelos findByValorFacial (double valorFacial);
	Modelos findByUnidad (String unidad);
	Modelos findByDiametro (double diametro);
	Modelos findByPeso (double peso);
	Modelos findByMetal (String metal);
	Modelos findByDescripcion (String descripcion);
	
	List<Modelos> findByValorFacialAndUnidad (double valorFacial, String unidad);
	
}
