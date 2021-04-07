package sv.com.drm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.drm.model.Producto;
import sv.com.drm.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Override
	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}

	@Override
	public void saveProducto(Producto producto) {
		this.productoRepository.save(producto);		
	}

	@Override
	public Producto getProductoById(long id) {
		Optional<Producto> optional = productoRepository.findById(id);
		Producto producto = null;
		if (optional.isPresent()) {
			producto = optional.get();
		} else {
			throw new RuntimeException(" Producto not found for id :: " + id);
		}
		return producto;
	}

}
