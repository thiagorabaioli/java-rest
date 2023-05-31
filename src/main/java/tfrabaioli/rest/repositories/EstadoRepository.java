package tfrabaioli.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tfrabaioli.rest.domain.Estado;


@Repository
public interface EstadoRepository  extends JpaRepository<Estado, Integer>{

}
