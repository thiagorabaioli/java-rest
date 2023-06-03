package tfrabaioli.rest;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tfrabaioli.rest.domain.Categoria;
import tfrabaioli.rest.domain.Cidade;
import tfrabaioli.rest.domain.Cliente;
import tfrabaioli.rest.domain.Endereco;
import tfrabaioli.rest.domain.Estado;
import tfrabaioli.rest.domain.Pagamento;
import tfrabaioli.rest.domain.PagamentoComBoleto;
import tfrabaioli.rest.domain.PagamentoComCartao;
import tfrabaioli.rest.domain.Pedido;
import tfrabaioli.rest.domain.Produto;
import tfrabaioli.rest.domain.enums.EstadoPagamento;
import tfrabaioli.rest.domain.enums.TipoCliente;
import tfrabaioli.rest.repositories.CategoriaRepository;
import tfrabaioli.rest.repositories.CidadeRepository;
import tfrabaioli.rest.repositories.ClienteRepository;
import tfrabaioli.rest.repositories.EnderecoRepository;
import tfrabaioli.rest.repositories.EstadoRepository;
import tfrabaioli.rest.repositories.PagamentoRepository;
import tfrabaioli.rest.repositories.PedidoRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepo;
	@Autowired
	private EnderecoRepository enderecoRepo;
	
	@Autowired
	private PagamentoRepository pagamentoRepo;
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(RestJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
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
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cid1);
		Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cid2);

		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, end2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
	    ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		
		
		produtoRepo.saveAll(Arrays.asList(p1,p2,p3));
		categoriaRepo.saveAll(Arrays.asList(cat1,cat2));
		
		estadoRepo.saveAll(Arrays.asList(e1,e2));
		cidadeRepo.saveAll(Arrays.asList(cid1,cid2,cid3));
		
		clienteRepo.saveAll(Arrays.asList(cli1));
		enderecoRepo.saveAll(Arrays.asList(end1, end2));
		
		
		pedidoRepo.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepo.saveAll(Arrays.asList(pagto1, pagto2));
		
		
	}

}
