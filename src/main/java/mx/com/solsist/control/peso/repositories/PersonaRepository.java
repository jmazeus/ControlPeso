package mx.com.solsist.control.peso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.com.solsist.control.peso.domain.PersonaEntity;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {

	// Native query: throw InvalidJpaQueryMethodException
	@Query(value = "SELECT * FROM persona p WHERE p.estatus =?1", nativeQuery = true)
	List<PersonaEntity> findByEstatus(boolean estatus);
}
