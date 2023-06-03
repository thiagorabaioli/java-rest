package tfrabaioli.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfrabaioli.rest.domain.Pagamento;


@Repository
public interface PagamentoRepository  extends JpaRepository<Pagamento, Integer>{

}
