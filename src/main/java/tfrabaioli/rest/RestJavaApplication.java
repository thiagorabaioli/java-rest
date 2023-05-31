package tfrabaioli.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tfrabaioli.rest.domain.Categoria;
import tfrabaioli.rest.domain.Produto;
import tfrabaioli.rest.repositories.CategoriaRepository;
import tfrabaioli.rest.repositories.ProdutoRepository;

@SpringBootApplication
public class RestJavaApplication  implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(RestJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		categoriaRepo.saveAll(Arrays.asList(cat1,cat2));
		
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3));
		
		
	}

}
