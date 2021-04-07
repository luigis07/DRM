package sv.com.drm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.com.drm.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long>{

}
