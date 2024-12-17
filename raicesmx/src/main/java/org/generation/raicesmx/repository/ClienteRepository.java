package org.generation.raicesmx.repository;

import org.generation.raicesmx.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	@Query("select u from ClienteEntity u where u.correo = ?1")
	ClienteEntity findByEmail(String correo);
}
