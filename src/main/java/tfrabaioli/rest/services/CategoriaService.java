package tfrabaioli.rest.services;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfrabaioli.rest.domain.Categoria;
import tfrabaioli.rest.repositories.CategoriaRepository;
import tfrabaioli.rest.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objecto não encontrado " + Categoria.class.getName() + " id "));
	}
}


