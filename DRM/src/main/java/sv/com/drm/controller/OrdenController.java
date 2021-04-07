package sv.com.drm.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sv.com.drm.model.CatEstado;
import sv.com.drm.model.Cliente;
import sv.com.drm.model.Orden;
import sv.com.drm.model.Producto;
import sv.com.drm.model.ViewOrders;
import sv.com.drm.service.CatEstadoService;
import sv.com.drm.service.ClienteService;
import sv.com.drm.service.OrdenService;
import sv.com.drm.service.ProductoService;
import sv.com.drm.service.ViewOrdersService;

@Controller
public class OrdenController {

	public List<Cliente> clientes;

	public List<Producto> productos;

	@Autowired
	private OrdenService ordenService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private CatEstadoService catEstadoService;

	@Autowired
	private ViewOrdersService viewOrdersService;

	@GetMapping("/")
	public String index(Model model) {
		List<ViewOrders> vista = viewOrdersService.getAllViewOrders();
		model.addAttribute("vista", vista);
		return "index";
	}

	@GetMapping("/showNewOrden")
	public String showNewEmployeeForm(Model model) {
		Orden orden = new Orden();

		clientes = clienteService.getAllClientes();
		productos = productoService.getAllProductos();

		model.addAttribute("orden", orden);
		model.addAttribute("clientes", clientes);
		model.addAttribute("productos", productos);
		return "newOrden";
	}

	@PostMapping("/save")
	public String saveOrden(@ModelAttribute("orden") Orden orden) {

		Cliente cli = clienteService.getClienteById(orden.getClienteId().getId());
		Producto prod = productoService.getProductoById(orden.getProductoId().getId());
		CatEstado estado = catEstadoService.getEstadoById(1);

		orden.setClienteId(cli);
		orden.setProductoId(prod);
		orden.setMontoTotal(prod.getPrecio().multiply(new BigDecimal(orden.getCantidad())));
		orden.setFechaCrea(new Date());
		orden.setUsuarioCrea("luis.gonzalez");
		orden.setCatEstadoId(estado);
		ordenService.saveOrden(orden);
		return "redirect:/";
	}

}
