package sv.com.drm.service;

import java.util.List;

import sv.com.drm.model.Producto;

public interface ProductoService {

	List<Producto> getAllProductos();

	void saveProducto(Producto producto);

	Producto getProductoById(long id);
}
