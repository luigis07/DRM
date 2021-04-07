package sv.com.drm.service;

import java.util.List;

import sv.com.drm.model.Orden;

public interface OrdenService {

	List<Orden> getAllOrdenes();
	
	void saveOrden(Orden orden);
	
	Orden getOrdenById(long id);
	
    void deleteOrdenById(long id);
    
//    String changeStage(Long idOrden);
}
