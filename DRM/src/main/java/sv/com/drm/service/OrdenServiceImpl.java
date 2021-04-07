package sv.com.drm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.drm.model.Orden;
import sv.com.drm.repository.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	private OrdenRepository ordenRepository;

	@Override
	public List<Orden> getAllOrdenes() {
		return ordenRepository.findAll();
	}

	@Override
	public void saveOrden(Orden orden) {
		this.ordenRepository.save(orden);
	}

	@Override
	public Orden getOrdenById(long id) {
		Optional<Orden> optional = ordenRepository.findById(id);
		Orden orden = null;
		if (optional.isPresent()) {
			orden = optional.get();
		} else {
			throw new RuntimeException(" Orden not found for id :: " + id);
		}
		return orden;
	}

	@Override
	public void deleteOrdenById(long id) {
		this.ordenRepository.deleteById(id);
	}

}
