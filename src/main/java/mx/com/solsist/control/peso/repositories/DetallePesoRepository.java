package mx.com.solsist.control.peso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.solsist.control.peso.domain.DetallePesoEntity;


@Repository
public interface DetallePesoRepository extends JpaRepository<DetallePesoEntity, Integer> {


}
