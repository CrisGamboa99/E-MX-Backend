package org.generation.raicesmx.repository;

import org.generation.raicesmx.model.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StatusRepository extends JpaRepository<StatusEntity, Long> {

	@Query("select s from StatusEntity s where s.tipo_status = ?1")
	StatusEntity findByStatus(String nombre);
}
