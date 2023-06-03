package tfrabaioli.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfrabaioli.rest.domain.Pedido;
import tfrabaioli.rest.repositories.PedidoRepository;
import tfrabaioli.rest.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido findbyId(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto nao encontrado! id: " + id + " Tipo:" + Pedido.class.getName()));
	}

}
