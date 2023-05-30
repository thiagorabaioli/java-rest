package tfrabaioli.rest.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tfrabaioli.rest.domain.Categoria;

@RestController
@RequestMapping (value = "/categorias")
public class CategoriaResource {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> findAll() {
		 Categoria c1 = new Categoria(1, "test");
		 Categoria c2 = new Categoria(2, "test2");
		 List<Categoria> list = new ArrayList<>();
		 list.addAll(Arrays.asList(c1,c2));
		 return list;
	}

}
