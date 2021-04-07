package sv.com.drm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.com.drm.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
