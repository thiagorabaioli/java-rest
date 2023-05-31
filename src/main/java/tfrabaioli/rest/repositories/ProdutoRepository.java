package tfrabaioli.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfrabaioli.rest.domain.Produto;


@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer>{

}
