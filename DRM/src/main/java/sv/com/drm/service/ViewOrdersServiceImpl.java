package sv.com.drm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.drm.model.ViewOrders;
import sv.com.drm.repository.ViewOrdersRepository;

@Service
public class ViewOrdersServiceImpl implements ViewOrdersService {

	@Autowired
	private ViewOrdersRepository viewOrdersRepository;

	@Override
	public List<ViewOrders> getAllViewOrders() {
		return viewOrdersRepository.findAll();
	}
}
