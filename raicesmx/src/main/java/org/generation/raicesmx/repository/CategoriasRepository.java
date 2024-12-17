package org.generation.raicesmx.repository;

import org.generation.raicesmx.model.CategoriasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriasRepository extends JpaRepository<CategoriasEntity, Long>  {

	@Query("select c from CategoriasEntity c where c.nombre_categoria = ?1")
	CategoriasEntity findByNombreCategoria(String nombre);
}
