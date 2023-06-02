package tfrabaioli.rest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfrabaioli.rest.domain.Cliente;
import tfrabaioli.rest.repositories.ClienteRepository;
import tfrabaioli.rest.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente findbyId(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto nao encontrado! id: " + id + " Tipo:" + Cliente.class.getName()));
	}

}
