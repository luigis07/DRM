package sv.com.drm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.com.drm.model.ViewOrders;

public interface ViewOrdersRepository extends JpaRepository<ViewOrders, Long> {

}