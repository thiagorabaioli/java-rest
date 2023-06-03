package tfrabaioli.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfrabaioli.rest.domain.Pedido;


@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Integer>{

}
