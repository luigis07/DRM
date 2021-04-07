package sv.com.drm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.drm.model.CatEstado;
import sv.com.drm.repository.CatEstadoRepository;

@Service
public class CatEstadoServiceImpl implements CatEstadoService {

	@Autowired
	private CatEstadoRepository catEstadoRepository;

	@Override
	public CatEstado getEstadoById(long id) {
		Optional<CatEstado> optional = catEstadoRepository.findById(id);
		CatEstado catEstado = null;
		if (optional.isPresent()) {
			catEstado = optional.get();
		} else {
			throw new RuntimeException(" Estado not found for id :: " + id);
		}
		return catEstado;
	}

}
