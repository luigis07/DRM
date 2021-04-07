package sv.com.drm.service;

import java.util.List;

import sv.com.drm.model.Cliente;

public interface ClienteService {

	List<Cliente> getAllClientes();

	void saveCliente(Cliente cliente);

	Cliente getClienteById(long id);
}
