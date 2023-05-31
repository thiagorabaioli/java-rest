package tfrabaioli.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tfrabaioli.rest.domain.Categoria;
import tfrabaioli.rest.domain.Cidade;
import tfrabaioli.rest.domain.Estado;
import tfrabaioli.rest.domain.Produto;
import tfrabaioli.rest.repositories.CategoriaRepository;
import tfrabaioli.rest.repositories.CidadeRepository;
import tfrabaioli.rest.repositories.EstadoRepository;
import tfrabaioli.rest.repositories.ProdutoRepository;

@SpringBootApplication
public class RestJavaApplication  implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private ProdutoRepository produtoRepo;
	
	@Autowired
	private EstadoRepository estadoRepo;
	
	@Autowired
	private CidadeRepository cidadeRepo;
	
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
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado e1 = new Estado(null, "Estado1");
		Estado e2 = new Estado(null, "Estado2");
		
		Cidade cid1 = new Cidade(null, "Cidade1", e1);
		Cidade cid2 = new Cidade(null, "Cidade2", e2);
		Cidade cid3 = new Cidade(null, "Cidade3", e1);
		
		e1.getCidades().addAll(Arrays.asList(cid1, cid3));
		e2.getCidades().addAll(Arrays.asList(cid2));
		
		
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3));
		categoriaRepo.saveAll(Arrays.asList(cat1,cat2));
		
		estadoRepo.saveAll(Arrays.asList(e1,e2));
		cidadeRepo.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		
		
	}

}
