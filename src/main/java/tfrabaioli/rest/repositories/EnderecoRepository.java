package tfrabaioli.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfrabaioli.rest.domain.Endereco;


@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Integer>{

}
