package org.generation.raicesmx.repository;

import org.generation.raicesmx.model.ArtesanoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtesanoRepository extends JpaRepository <ArtesanoEntity, Long> {

	@Query("select a from ArtesanoEntity a where a.correo = ?1")
	ArtesanoEntity findByEmail(String correo);
}
