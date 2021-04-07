package sv.com.drm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.com.drm.model.Cliente;
import sv.com.drm.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	@Override
	public void saveCliente(Cliente cliente) {
		this.clienteRepository.save(cliente);
	}

	@Override
	public Cliente getClienteById(long id) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		Cliente cliente = null;
		if (optional.isPresent()) {
			cliente = optional.get();
		} else {
			throw new RuntimeException(" Cliente not found for id :: " + id);
		}
		return cliente;
	}
}
